package com.agilemidwest.agility.controller

import com.agilemidwest.agility.contract.RegistrationRequest
import com.agilemidwest.agility.domain.AttendeeSession
import com.agilemidwest.agility.repository.AttendeeSessionRepository
import com.agilemidwest.agility.service.QueueService
import com.agilemidwest.agility.service.RegistrationService
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping("/registration")
class RegistrationController(
        private val registrationService: RegistrationService,
        private val attendeeSessionRepository: AttendeeSessionRepository,
        private val queueService: QueueService
) {
    @RequestMapping(method = [POST], value = ["http"])
    @ResponseStatus(OK)
    fun registerByHttp(@RequestBody registrationRequest: RegistrationRequest) {
        registrationService.registerByHttp(registrationRequest)
    }

    @RequestMapping(method = [POST], value = ["queue"])
    @ResponseStatus(OK)
    fun registerByQueue(@RequestBody registrationRequest: RegistrationRequest) {
        queueService.sendMessage(registrationRequest)
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