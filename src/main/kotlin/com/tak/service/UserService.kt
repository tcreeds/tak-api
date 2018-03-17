package com.tak.service

import com.tak.repository.UserRepository
import com.tak.repository.entity.UserEntity
import com.tak.rest.resources.UserResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(

        @Autowired
        val userRepository: UserRepository
){
    fun createUser(resource: UserResource) {
        print(resource.id.toString() + " " + resource.username + " " + resource.password)
        userRepository.save(UserEntity.fromResource(resource))
    }
}