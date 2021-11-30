package com.sso.ssoapi.repository

import com.sso.ssoapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String> {
    fun findByEmailAndPassword(email: String, password: String): User?
    fun findFirstByEmail(email: String): User?
}