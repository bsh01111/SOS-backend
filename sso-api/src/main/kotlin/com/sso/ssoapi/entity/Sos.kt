package com.sso.ssoapi.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.format.annotation.DateTimeFormat

@Entity
@Table(name = "sos", schema = "sos")
data class Sos(
    @Column(nullable = false) val userId: Int,
    @Column(nullable = false) val sosContent: String,
    @Column(nullable = false) val location: String,
    @Column(nullable = false) val cost: Int,
    @Column val mediaURL: string,
    @Column(nullable = false) val approval: String,
    @Column(nullable = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") val createdAt: Date,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null
}