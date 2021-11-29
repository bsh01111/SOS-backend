package com.sso.ssoapi.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
data class User(
    @Id
    @Column(name = "id")
    val id: Int,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "tel_number")
    val telNumber: String,

    @Column(name = "nickname")
    val nickname: String,

    @Column(name = "date_of_birth")
    val dateOfBirth: Date,

    @Column(name = "profile_id")
    val profileId: Int,

    @Column(name = "created_at")
    val createdAt: Date,

    @Column(name = "updated_at")
    val updatedAt: Date
)