package com.agilemidwest.agility.repository

import com.agilemidwest.agility.domain.Attendee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository : CrudRepository<Attendee, Long>