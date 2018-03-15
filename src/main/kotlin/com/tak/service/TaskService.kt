package com.tak.service

import com.tak.repository.TagRepository
import com.tak.repository.TaskRepository
import com.tak.repository.entity.TagEntity
import com.tak.repository.entity.TaskEntity
import com.tak.rest.resources.TaskResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService (

        @Autowired
        val taskRepository: TaskRepository,

        @Autowired
        val tagRepository: TagRepository

){
    fun updateTasks(resources: List<TaskResource>) {
        val taskEntities: List<TaskEntity> = TaskEntity.fromResources(resources)
    }

    fun saveTask(task: TaskResource){
        val taskEntity: TaskEntity = TaskEntity.fromResource(task)
        taskRepository.save(taskEntity)
        val tagEntities: List<TagEntity> = TagEntity.fromResources(task.tags, taskEntity)
        tagRepository.save(tagEntities)
    }
}