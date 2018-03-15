package com.tak.repository

import com.tak.repository.entity.TaskEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : CrudRepository<TaskEntity, String> {
    fun findById(id: String): TaskEntity
    fun findByName(name: String): TaskEntity
}