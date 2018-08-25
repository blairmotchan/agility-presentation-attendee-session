package com.agilemidwest.agility.repository

import com.agilemidwest.agility.domain.AttendeeSession
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendeeSessionRepository : CrudRepository<AttendeeSession, Long> {
    fun findByAttendeeId(id: Long): List<AttendeeSession>

    fun findBySessionId(id: Long): List<AttendeeSession>
}