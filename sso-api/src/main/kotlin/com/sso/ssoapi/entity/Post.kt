package com.sso.ssoapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "post", schema = "sos")
data class Post(
        @Column(nullable = false) val userId: Long,
        @Column(nullable = false) val content: String,
        @Column(nullable = false) val imageUrl: String,
) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
}