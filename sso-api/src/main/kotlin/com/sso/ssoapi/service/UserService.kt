package com.sso.ssoapi.service

import com.sso.ssoapi.controller.dto.user.UserSignUpRequest
import com.sso.ssoapi.entity.User
import com.sso.ssoapi.repository.UserRepository
import com.sso.ssoapi.repository.UserQueryDslRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import com.sso.ssoapi.dto.UserDetail

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userQueryDslRepository: UserQueryDslRepository
) {
    @Transactional(readOnly = true)
    fun login(email: String, password: String): User? {
        return userRepository.findByEmailAndPassword(email, password)
    }

    @Transactional
    fun signUp(userSignUpRequest: UserSignUpRequest): User {
        val existUser = userRepository.findFirstByEmail(userSignUpRequest.email)
        if (existUser != null) throw ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "해당 email은 이미 존재합니다."
        )
        val user = User(
            userSignUpRequest.email,
            userSignUpRequest.password,
            userSignUpRequest.name,
            userSignUpRequest.nickname,
            userSignUpRequest.birthday,
            userSignUpRequest.sex,
            userSignUpRequest.phoneNumber,
        )
        return userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun findUserList(): List<UserDetail> {
        return userQueryDslRepository.findUserList()
    }
}