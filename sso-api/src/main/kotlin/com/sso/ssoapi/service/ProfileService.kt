package com.sso.ssoapi.service

import com.sso.ssoapi.controller.dto.profile.PostEnrollRequest
import com.sso.ssoapi.controller.dto.profile.ProfileUpdateRequest
import org.springframework.stereotype.Service
import com.sso.ssoapi.dto.ProfileDetail
import com.sso.ssoapi.dto.PostDetail
import com.sso.ssoapi.entity.Post
import com.sso.ssoapi.repository.PostRepository
import com.sso.ssoapi.repository.ProfileQueryDslRepository
import org.springframework.transaction.annotation.Transactional

@Service
class ProfileService (
    private val postRepository: PostRepository,
    private val profileQueryDslRepository: ProfileQueryDslRepository,
    ) {

    @Transactional(readOnly = true)
    fun findProfileDetail(id: Long): ProfileDetail? {
        return profileQueryDslRepository.findProfileDetail(id)
    }

    @Transactional(readOnly = true)
    fun findPostListByUserId(id: Long): List<PostDetail> {
        return profileQueryDslRepository.findPostListByUserId(id)
    }

    @Transactional
    fun enrollPost(postEnrollRequest: PostEnrollRequest): Post {
        val post = Post(
            postEnrollRequest.userId,
            postEnrollRequest.content,
            postEnrollRequest.imageUrl,
        )
        return postRepository.save(post)
    }

    @Transactional
    fun updateProfile(profileUpdateRequest: ProfileUpdateRequest, id: Long) {
        profileQueryDslRepository.updateProfile(profileUpdateRequest, id)
    }
}