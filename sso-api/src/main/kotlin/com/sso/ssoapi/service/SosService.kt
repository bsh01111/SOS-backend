package com.sso.ssoapi.service

import com.sso.ssoapi.entity.Sos
import com.sso.ssoapi.repository.SosRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class SosService(
    private val sosRepository: SosRepository
}