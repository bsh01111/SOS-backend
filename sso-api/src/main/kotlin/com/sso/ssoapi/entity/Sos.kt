package com.sso.ssoapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "sos", schema = "sos")
data class Sos(
    @Column(nullable = false) val content: String,
    @Column(nullable = false) val location: String,
    @Column(nullable = false) val cost: Long,
    @Column(nullable = false) val mediaUrl: String?,
    @Column(nullable = false) val userId: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
