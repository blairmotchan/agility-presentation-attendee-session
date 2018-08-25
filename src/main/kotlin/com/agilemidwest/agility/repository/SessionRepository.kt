package com.agilemidwest.agility.repository

import com.agilemidwest.agility.domain.Session
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionRepository: CrudRepository<Session, Long>