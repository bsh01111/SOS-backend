package com.sso.ssoapi.repository

import com.sso.ssoapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, String> {
    fun findAllBy(): List<User>?

    fun findById(id: Int): User?
}