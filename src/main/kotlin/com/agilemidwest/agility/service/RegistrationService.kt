package com.agilemidwest.agility.service

import com.agilemidwest.agility.contract.RegistrationRequest
import com.agilemidwest.agility.contract.RegistrationResponse
import com.agilemidwest.agility.domain.AttendeeSession
import com.agilemidwest.agility.repository.AttendeeRepository
import com.agilemidwest.agility.repository.AttendeeSessionRepository
import com.agilemidwest.agility.repository.SessionRepository
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import org.springframework.stereotype.Service

@Service
class RegistrationService(
        private val sessionRepository: SessionRepository,
        private val attendeeRepository: AttendeeRepository,
        private val attendeeSessionRepository: AttendeeSessionRepository
) {
    private var objectMapper = com.fasterxml.jackson.databind.ObjectMapper()

    fun registerByHttp(request: RegistrationRequest) {
        val jsonResponse: HttpResponse<JsonNode> = Unirest.post("http://localhost:8083/registration")
                .header("Content-Type", "application/json")
                .body(objectMapper.writeValueAsString(request))
                .asJson()
        val response = objectMapper.readValue(jsonResponse.body.toString(), RegistrationResponse::class.java)
        completeRegistration(response)
    }

    fun completeRegistration(response: RegistrationResponse) {
        val attendee = attendeeRepository.findById(response.attendeeId).get()
        val session = sessionRepository.findById(response.sessionId).get()
        attendeeSessionRepository.save(AttendeeSession(null, session, attendee))
    }
}