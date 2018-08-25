package com.agilemidwest.agility.controller

import com.agilemidwest.agility.contract.RegistrationRequest
import com.agilemidwest.agility.contract.RegistrationResponse
import com.agilemidwest.agility.domain.AttendeeSession
import com.agilemidwest.agility.domain.QueueResponse
import com.agilemidwest.agility.repository.AttendeeSessionRepository
import com.agilemidwest.agility.service.QueueService
import com.agilemidwest.agility.service.RegistrationService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/registration")
class RegistrationController(
        private val registrationService: RegistrationService,
        private val attendeeSessionRepository: AttendeeSessionRepository,
        private val queueService: QueueService
) {
    @RequestMapping(method = [POST], value = ["http"])
    fun registerByHttp(@RequestBody registrationRequest: RegistrationRequest): RegistrationResponse {
        return registrationService.registerByHttp(registrationRequest)
    }

    @RequestMapping(method = [POST], value = ["queue"])
    fun registerByQueue(@RequestBody registrationRequest: RegistrationRequest): QueueResponse {
        queueService.sendMessage(registrationRequest)
        return QueueResponse(true, registrationRequest.sessionId, registrationRequest.attendeeId)
    }

    @RequestMapping("/attendee/{attendeeId}/sessions")
    fun getSessionsForAttendee(@PathVariable attendeeId: Long): List<AttendeeSession> {
        return attendeeSessionRepository.findByAttendeeId(attendeeId)
    }

    @RequestMapping("/session/{sessionId}/attendees")
    fun getAttendeesForSession(@PathVariable sessionId: Long): List<AttendeeSession> {
        return attendeeSessionRepository.findBySessionId(sessionId)
    }
}