package com.sso.ssoapi.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sso.ssoapi.entity.QUser.user
import com.sso.ssoapi.entity.User
import com.sso.ssoapi.entity.Category
import com.sso.ssoapi.entity.QProfile.profile
import com.sso.ssoapi.dto.QUserDetail
import com.sso.ssoapi.dto.UserDetail
import org.springframework.stereotype.Repository

@Repository
class UserQueryDslRepository(
    val jpaQueryFactory: JPAQueryFactory
) {
    fun findUser(): List<User> {
        return jpaQueryFactory.select(user).fetch()
    }

    fun findUserList(): List<UserDetail> {
        return jpaQueryFactory.selectfrom(user)
            .innerjoin(profile).on(user.id.eq(profile.userId))
            .select(
            QuserDetail(
                user.id,
                user.email,
                user.name,
                user.phoneNumber,
                user.nickName,
                user.birthDay,
                profile.url,
            )
        ).fetch()
    }
}