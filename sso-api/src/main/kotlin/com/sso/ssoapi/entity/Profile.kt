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
    @Column(nullable = false) val career: String,
    @Column(nullable = false) val elementrySchool: String,
    @Column(nullable = false) val middleSchool: String,
    @Column(nullable = false) val highSchool: String,
    @Column(nullable = false) val university: String,
    @Column(nullable = false) val originPlace: String,
    @Column(nullable = false) val residence: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

enum class Category {
    PROFILE
}
