package com.sso.ssoapi.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.sso.ssoapi.dto.ChattingRoomDetail
import com.sso.ssoapi.repository.ChattingRoomQueryDslRepository

@Service
class ChattingRoomService(
    private val chattingRoomQueryDslRepository: ChattingRoomQueryDslRepository
) {
    @Transactional(readOnly = true)
    fun findChattingRoomListById(userId: Long): List<ChattingRoomDetail> {
        return chattingRoomQueryDslRepository.findChattingRoomListById(userId)
    }
}