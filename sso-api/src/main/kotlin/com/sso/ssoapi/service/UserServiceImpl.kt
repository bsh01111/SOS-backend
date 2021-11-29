package com.sso.ssoapi.service

import com.sso.ssoapi.entity.User
import com.sso.ssoapi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserServiceImpl constructor(@Autowired private val userRepository: UserRepository): UserService {
    override fun getAllUsers(): List<User>? =
        userRepository.findAllBy()

    override fun getUser(id: Int): User? =
        userRepository.findById(id)

    @Transactional
    override fun saveUser(user: User): User? =
        userRepository.save(user)
}