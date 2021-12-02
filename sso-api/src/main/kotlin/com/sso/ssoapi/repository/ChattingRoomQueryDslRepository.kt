package com.sso.ssoapi.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sso.ssoapi.dto.QChattingRoomDetail
import com.sso.ssoapi.dto.ChattingRoomDetail
import com.sso.ssoapi.entity.QChattingRoom.chattingroom
import com.sso.ssoapi.entity.ChattingRoom
import com.sso.ssoapi.entity.QUser.user
import com.sso.ssoapi.entity.User
import com.sso.ssoapi.entity.Category
import com.sso.ssoapi.entity.QProfile.profile
import org.springframework.stereotype.Repository

@Repository
class ChattingRoomQueryDslRepository(
    val jpaQueryFactory: JPAQueryFactory
) {
    fun findChattingRoomList(): List<ChattingRoomDetail> {
        return jpaQueryFactory.selectfrom(chattingroom)
            .innerJoin(user).on(user.id.eq(chattingroom.userId))
            .leftJoin(profile).on(chattingroom.userId.eq(profile.userId).and(profile.category.eq(Category.PROFILE)))
            .select(
                QChattingRoomDetail(
                    chattingroom.id,
                    user.userNickname,
                    profile.url,
                )
            )
            .fetch()
    }
}