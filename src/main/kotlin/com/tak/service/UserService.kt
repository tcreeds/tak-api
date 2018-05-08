package com.tak.service

import com.tak.repository.UserDataRepository
import com.tak.repository.entity.UserDataEntity
import com.tak.rest.resources.UserResource
import org.apache.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(

        @Autowired
        val repository: UserDataRepository,

        val bCryptPasswordEncoder: BCryptPasswordEncoder = BCryptPasswordEncoder()
){
    fun createUser(resource: UserResource) : Boolean {
        print(resource.id.toString() + " " + resource.username + " " + resource.password)
        if (repository.findByUsername(resource.username) == null) {
            repository.save(UserDataEntity(resource.username, bCryptPasswordEncoder.encode(resource.password)))
            return true
        }
        return false
    }

    fun checkLogin(resource: UserResource): Boolean {
        val name: String = resource.username
        val userDataEntity: UserDataEntity? = repository.findByUsername(name)
        if (userDataEntity != null && bCryptPasswordEncoder.matches(resource.password, userDataEntity.password))
            return true
        return false
    }
}