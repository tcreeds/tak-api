package com.tak.service

import com.tak.repository.UserRepository
import com.tak.repository.entity.UserEntity
import com.tak.rest.resources.UserResource
import org.apache.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(

        @Autowired
        val userRepository: UserRepository,

        val bCryptPasswordEncoder: BCryptPasswordEncoder = BCryptPasswordEncoder()
){
    fun createUser(resource: UserResource) : Boolean {
        print(resource.id.toString() + " " + resource.username + " " + resource.password)
        if (userRepository.findByUsername(resource.username) == null) {
            userRepository.save(UserEntity(UUID.randomUUID().toString(), resource.username, bCryptPasswordEncoder.encode(resource.password)))
            return true
        }
        return false
    }

    fun checkLogin(resource: UserResource): Boolean {
        val name: String = resource.username
        val userEntity: UserEntity? = userRepository.findByUsername(name)
        if (userEntity != null && bCryptPasswordEncoder.matches(resource.password, userEntity?.password))
            return true
        return false
    }
}