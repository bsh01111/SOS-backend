package com.sso.ssoapi.service

import com.sso.ssoapi.entity.Sos
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import com.sso.ssoapi.dto.SosDetail
import com.sso.ssoapi.repository.SosQueryDslRepository

@Service
class SosService(
    private val sosQueryDslRepository: SosQueryDslRepository
) {
    @Transactional(readOnly = true)
    fun findSosList(): List<SosDetail> {
        return sosQueryDslRepository.findSosList()
    }

    @Transactional(readOnly = true)
    fun findSosDetail(SosId: Long): SosDetail? {
        return sosQueryDslRepository.findSosDetail(SosId)
    }
}