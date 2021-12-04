package com.sso.ssoapi.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sso.ssoapi.dto.QChattingRoomDetail
import com.sso.ssoapi.dto.ChattingRoomDetail
import com.sso.ssoapi.entity.QChattingRoom.chattingRoom
import com.sso.ssoapi.entity.QUser.user
import com.sso.ssoapi.entity.Category
import com.sso.ssoapi.entity.QProfile.profile
import org.springframework.stereotype.Repository

@Repository
class ChattingRoomQueryDslRepository(
    val jpaQueryFactory: JPAQueryFactory
) {
    fun findChattingRoomList(): List<ChattingRoomDetail> {
        return jpaQueryFactory.selectFrom(chattingRoom)
            .innerJoin(user).on(user.id.eq(chattingRoom.userId))
            .leftJoin(profile).on(chattingRoom.userId.eq(profile.userId).and(profile.category.eq(Category.PROFILE)))
            .select(
                QChattingRoomDetail(
                    chattingRoom.id,
                    user.nickname,
                    profile.url,
                )
            )
            .fetch()
    }
}