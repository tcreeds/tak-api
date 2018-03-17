package com.tak.repository

import com.tak.repository.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findById(id: Long): UserEntity
    fun findByUsername(name: String): UserEntity
}