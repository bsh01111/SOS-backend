package com.sso.ssoapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "sos_user_apply", schema = "sos")
data class SosUserApply(
    @Column(nullable = false) val userId: Long,
    @Column(nullable = false) val sosId: Long,
    @Column(nullable = false) @Enumerated(EnumType.STRING) val status: SosUserApplyStatus,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L
)

enum class SosUserApplyStatus {
    WAIT, ACCEPT, REFUSE, CANCEL
}
