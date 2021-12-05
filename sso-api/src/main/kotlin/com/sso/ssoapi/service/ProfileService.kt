package com.sso.ssoapi.service

import org.springframework.stereotype.Service
import com.sso.ssoapi.dto.ProfileDetail
import com.sso.ssoapi.repository.ProfileQueryDslRepository
import org.springframework.transaction.annotation.Transactional

@Service
class ProfileService (
    private val profileQueryDslRepository: ProfileQueryDslRepository
    ) {

    @Transactional(readOnly = true)
    fun findProfileDetail(id: Long): ProfileDetail? {
        return profileQueryDslRepository.findProfileDetail(id)
    }
}