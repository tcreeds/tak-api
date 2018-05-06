package com.tak.repository

import com.tak.repository.entity.UserEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@EnableScan
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByUsername(name: String): UserEntity?
}