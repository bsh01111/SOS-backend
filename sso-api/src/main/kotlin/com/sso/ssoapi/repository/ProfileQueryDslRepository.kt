package com.sso.ssoapi.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sso.ssoapi.dto.QProfileDetail
import com.sso.ssoapi.dto.ProfileDetail
import com.sso.ssoapi.entity.QProfile.profile
import com.sso.ssoapi.entity.QUser.user
import org.springframework.stereotype.Repository

@Repository
class ProfileQueryDslRepository(
    val jpaQueryFactory: JPAQueryFactory
) {
    fun findProfileDetail(UserId: Long): ProfileDetail? {
        return jpaQueryFactory.selectFrom(profile)
            .innerJoin(user).on(user.id.eq(profile.userId))
            .select(
                QProfileDetail(
                    profile.id,
                    profile.userId,
                    user.nickname,
                    profile.url,
                )
            )
            .where(profile.userId.eq(UserId))
            .fetchFirst()
    }
}