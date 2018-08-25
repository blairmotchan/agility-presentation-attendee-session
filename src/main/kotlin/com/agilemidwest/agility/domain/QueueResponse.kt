package com.agilemidwest.agility.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class QueueResponse(@JsonProperty("requestSent") val requestSent: Boolean,
                         @JsonProperty("sessionId") val sessionId: Long,
                         @JsonProperty("attendeeId") val attendeeId: Long)