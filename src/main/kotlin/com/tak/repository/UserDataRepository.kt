package com.tak.repository

import com.tak.repository.entity.UserDataEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@EnableScan
interface UserDataRepository : CrudRepository<UserDataEntity, Long> {
    fun findByUsername(name: String): UserDataEntity?
}