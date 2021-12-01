package com.sso.ssoapi.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sso.ssoapi.dto.QSosDetail
import com.sso.ssoapi.dto.SosDetail
import com.sso.ssoapi.entity.QSos.sos
import com.sso.ssoapi.entity.QUser.user
import org.springframework.stereotype.Repository

@Repository
class SosQueryDslRepository(
    val jpaQueryFactory: JPAQueryFactory
) {
    fun findSosList(): List<SosDetail> {
        return jpaQueryFactory.selectFrom(sos)
            .innerJoin(user).on(user.id.eq(sos.userId))
            .select(
                QSosDetail(
                    sos.id,
                    sos.content,
                    sos.location,
                    sos.cost,
                    sos.mediaUrl,
                    sos.userId,
                    user.nickname
                )
            )
            .orderBy(sos.id.desc())
            .fetch()
    }
}