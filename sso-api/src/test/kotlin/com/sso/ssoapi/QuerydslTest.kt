package com.sso.ssoapi

import com.sso.ssoapi.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest(classes = [SsoApiApplication::class])
@ContextConfiguration
class querydslTest(
    @Autowired
    val userRepository: UserRepository
) {
    @Test
    fun test() {
        val test2 = userRepository.findAll()
    }
}