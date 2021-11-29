package com.sso.ssoapi.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sso.ssoapi.entity.QUser.user
import com.sso.ssoapi.entity.User
import org.springframework.stereotype.Repository

@Repository
class UserQueryDslRepository(
    val jpaQueryFactory: JPAQueryFactory
) {
    fun findUser(): List<User> {
        return jpaQueryFactory.select(user).fetch()
    }

}