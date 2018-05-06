package com.tak.service

import com.tak.repository.TaskRepository
import com.tak.repository.entity.TaskEntity
import com.tak.rest.resources.TaskResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService (

        @Autowired
        val taskRepository: TaskRepository

){
    fun getTasks() : Array<TaskResource>{
        return TaskResource.fromEntities(taskRepository.findAll().toList()).toTypedArray()
    }

    fun saveTask(task: TaskResource){
        val taskEntity: TaskEntity = TaskEntity.fromResource(task)
        taskRepository.save(taskEntity)
    }
}