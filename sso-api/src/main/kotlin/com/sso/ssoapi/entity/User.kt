package com.sso.ssoapi.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.format.annotation.DateTimeFormat

@Entity
@Table(name = "user", schema = "sos")
data class User(
    @Column(nullable = false) val email: String,
    @Column(nullable = false) val password: String,
    @Column(nullable = false) val name: String,
    @Column(nullable = false) val nickname: String,
    @Column(nullable = false) @DateTimeFormat(pattern = "yyyy-MM-dd") val birthday: Date,
    @Column(nullable = false) @Enumerated(EnumType.STRING) val sex: Sex,
    @Column(nullable = false) val phoneNumber: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
}

enum class Sex {
    MAN, WOMAN, NONE
}
