package com.sso.ssoapi.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sso.ssoapi.dto.QSosDetail
import com.sso.ssoapi.dto.SosDetail
import com.sso.ssoapi.dto.QSosUserApplyDetail
import com.sso.ssoapi.dto.SosUserApplyDetail
import com.sso.ssoapi.dto.QMySosDetail
import com.sso.ssoapi.dto.MySosDetail
import com.sso.ssoapi.entity.Category
import com.sso.ssoapi.entity.QSosUserApply.sosUserApply
import com.sso.ssoapi.entity.QProfile.profile
import com.sso.ssoapi.entity.QSos.sos
import com.sso.ssoapi.entity.QUser.user
import com.sso.ssoapi.entity.SosUserApplyStatus
import org.springframework.stereotype.Repository

@Repository
class SosQueryDslRepository(
    val jpaQueryFactory: JPAQueryFactory
) {
    fun findSosList(): List<SosDetail> {
        return jpaQueryFactory.selectFrom(sos)
            .innerJoin(user).on(user.id.eq(sos.userId))
            .leftJoin(profile).on(sos.userId.eq(profile.userId).and(profile.category.eq(Category.PROFILE)))
            .select(
                QSosDetail(
                    sos.id,
                    profile.url,
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

    fun findSosListByUserId(UserId: Long): List<MySosDetail> {
        return jpaQueryFactory.selectFrom(sosUserApply)
            .innerJoin(sos).on(sos.id.eq(sosUserApply.sosId))
            .innerJoin(user).on(user.id.eq(sos.userId))
            .innerJoin(profile).on(sos.userId.eq(profile.userId))
            .select(
                QMySosDetail(
                    sos.id,
                    profile.url,
                    sos.content,
                    sos.location,
                    sos.cost,
                    sos.mediaUrl,
                    sos.userId,
                    user.nickname,
                    sosUserApply.status,
                )
            )
            .where(sos.userId.eq(UserId))
            .orderBy(sos.id.desc())
            .fetch()
    }

    fun findSosDetail(sosId: Long): SosDetail? {
        return jpaQueryFactory.selectFrom(sos)
            .innerJoin(user).on(user.id.eq(sos.userId))
            .leftJoin(profile).on(sos.userId.eq(profile.userId).and(profile.category.eq(Category.PROFILE)))
            .select(
                QSosDetail(
                    sos.id,
                    profile.url,
                    sos.content,
                    sos.location,
                    sos.cost,
                    sos.mediaUrl,
                    sos.userId,
                    user.nickname
                )
            )
            .where(sos.id.eq(sosId))
            .fetchFirst()
    }

    fun findApplyListByUserId(UserId: Long): List<SosUserApplyDetail> {
        return jpaQueryFactory.selectFrom(sosUserApply)
            .innerJoin(sos).on(sos.id.eq(sosUserApply.sosId))
            .innerJoin(user).on(user.id.eq(sos.userId))
            .leftJoin(profile).on(sos.userId.eq(profile.userId).and(profile.category.eq(Category.PROFILE)))
            .select(
                QSosUserApplyDetail(
                    sosUserApply.sosId,
                    sosUserApply.userId,
                    user.nickname,
                    profile.url,
                    sos.content,
                    sos.location,
                    sos.cost,
                    sosUserApply.status,
                )
            )
            .where(sosUserApply.userId.eq(UserId))
            .fetch()
    }

    fun cancelSosUserApply(sosId: Long, userId: Long) {
        jpaQueryFactory.update(sosUserApply)
            .set(sosUserApply.status, SosUserApplyStatus.CANCEL)
            .where(sosUserApply.sosId.eq(sosId).and(sosUserApply.userId.eq(userId)))
            .execute()
    }
}