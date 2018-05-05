package com.tak.service

import com.tak.repository.UserRepository
import com.tak.repository.entity.UserEntity
import com.tak.rest.resources.UserResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(

        @Autowired
        val userRepository: UserRepository,

        val bCryptPasswordEncoder: BCryptPasswordEncoder = BCryptPasswordEncoder()
){
    fun createUser(resource: UserResource) {
        print(resource.id.toString() + " " + resource.username + " " + resource.password)
        userRepository.save(UserEntity(null, resource.username, bCryptPasswordEncoder.encode(resource.password)))
    }

    fun checkLogin(resource: UserResource): Boolean{
        val userEntity: UserEntity? = userRepository.findByUsername(resource.username)
        if (userEntity != null && bCryptPasswordEncoder.matches(resource.password, userEntity?.password))
            return true
        return false
    }
}