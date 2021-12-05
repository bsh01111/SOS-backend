package com.sso.ssoapi.repository

import com.sso.ssoapi.entity.SosUserApply
import com.sso.ssoapi.entity.SosUserApplyStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SosUserApplyRepository : JpaRepository<SosUserApply, String> {
    fun findByUserIdAndSosIdAndStatusNot(userId: Long, sosId: Long, status: SosUserApplyStatus): SosUserApply?
}