package com.agilemidwest.agility.service

import com.agilemidwest.agility.contract.RegistrationRequest
import com.agilemidwest.agility.contract.RegistrationResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import java.util.concurrent.CountDownLatch

@Component
open class QueueService(
        private val tempalate: RabbitTemplate,
        @Qualifier("registrationQueue")
        private val registrationQueue: Queue,
        private val registrationService: RegistrationService) {
    private var latch: CountDownLatch = CountDownLatch(1)
    private var objectMapper = ObjectMapper()

    fun receiveMessage(payload: String) {
        try {
            val message = objectMapper.readValue(payload, RegistrationResponse::class.java)
            registrationService.completeRegistration(message)
            println(message)
        } catch (ignored: Exception) {
            println(ignored)
        }
        latch.countDown()
    }

    fun sendMessage(registrationRequest: RegistrationRequest) {
        val request = objectMapper.writeValueAsString(registrationRequest)
        tempalate.convertAndSend(registrationQueue.name, request)
    }

    fun getLatch(): CountDownLatch {
        return latch
    }
}