package com.agilemidwest.agility

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AgilityApplication

fun main(args: Array<String>) {
    runApplication<AgilityApplication>(*args)
}
