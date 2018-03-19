package com.tak

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableConfigurationProperties
@EnableWebSecurity
open class TakApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(TakApiApplication::class.java, *args)
}
