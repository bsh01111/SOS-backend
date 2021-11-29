package com.sso.ssoapi.service

import com.sso.ssoapi.entity.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun getAllUsers(): List<User>?

    fun getUser(id: Int): User?

    fun saveUser(user: User): User?
}