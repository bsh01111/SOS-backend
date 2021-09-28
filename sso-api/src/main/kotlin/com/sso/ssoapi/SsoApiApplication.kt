package com.sso.ssoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SsoApiApplication

fun main(args: Array<String>) {
	runApplication<SsoApiApplication>(*args)
}
