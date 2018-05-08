package com.tak.service

import com.tak.repository.UserDataRepository
import com.tak.repository.entity.TaskEntity
import com.tak.repository.entity.UserDataEntity
import com.tak.rest.resources.TaskResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService (

        @Autowired
        val repository: UserDataRepository

){
    fun getTasks(username: String) : Array<TaskResource>{
        val userData: UserDataEntity? = repository.findByUsername(username)
        if (userData != null)
            return TaskResource.fromEntities(userData.tasks.toList()).toTypedArray()
        return arrayOf()
    }

    fun saveTasks(username: String, resources: List<TaskResource>){
        val userDataEntity: UserDataEntity? = repository.findByUsername(username)
        if (userDataEntity != null) {
            val entities: List<TaskEntity> = TaskEntity.fromResources(resources)
            userDataEntity.tasks = entities
            repository.save(userDataEntity)
        }
    }
}