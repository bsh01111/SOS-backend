package com.sso.ssoapi.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sso.ssoapi.dto.QApplyDetail
import com.sso.ssoapi.dto.ApplyDetail
import com.sso.ssoapi.entity.QUser.user
import com.sso.ssoapi.entity.QProfile.profile
import com.sso.ssoapi.entity.QSosUserApply.sosUserApply
import org.springframework.stereotype.Repository

@Repository
class SosUserApplyQueryDslRepository(
    val jpaQueryFactory: JPAQueryFactory
) {
    fun findUserApplyListBySosId(SosId: Long): List<ApplyDetail> {
        return jpaQueryFactory.selectFrom(sosUserApply)
            .innerJoin(user).on(user.id.eq(sosUserApply.userId))
            .leftJoin(profile).on(profile.userId.eq(user.id))
            .select(
                QApplyDetail(
                    user.id,
                    user.nickname,
                    profile.url,
                    sosUserApply.status
                )
            )
            .where(sosUserApply.sosId.eq(SosId)).fetch()
    }
}