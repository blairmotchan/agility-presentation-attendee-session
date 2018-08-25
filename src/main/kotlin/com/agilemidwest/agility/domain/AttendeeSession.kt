package com.agilemidwest.agility.domain

import javax.persistence.*

@Entity
data class AttendeeSession(@Id @GeneratedValue val id: Long?,
                           @JoinColumn
                           @ManyToOne
                           val session: Session,
                           @JoinColumn
                           @ManyToOne
                           val attendee: Attendee)