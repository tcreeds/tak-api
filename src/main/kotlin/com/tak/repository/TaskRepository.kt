package com.tak.repository

import com.tak.repository.entity.TaskEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@EnableScan
interface TaskRepository : CrudRepository<TaskEntity, String> {
    fun findByName(name: String): TaskEntity
}