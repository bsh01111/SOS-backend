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
@Table(name = "profile", schema = "sos")
data class Profile(
    @Column(nullable = false) @Enumerated(EnumType.STRING) val category: Category,
    @Column(nullable = false) val url: String,
    @Column(nullable = false) val userId: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

enum class Category {
    PROFILE
}
