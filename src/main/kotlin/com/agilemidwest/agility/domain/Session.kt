package com.agilemidwest.agility.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Session(@Id @GeneratedValue val id: Long,
                   val name: String)