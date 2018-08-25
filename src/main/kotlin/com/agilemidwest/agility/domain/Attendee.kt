package com.agilemidwest.agility.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Attendee(@Id @GeneratedValue val id: Long = 0,
                    val name: String)



