package com.tak.rest

import com.tak.rest.resources.TaskResource
import com.tak.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = "/tasks")
class TaskController(

        @Autowired
        val taskService: TaskService

) {
    @GetMapping
    fun getTasks(authentication: Authentication) : Array<TaskResource> {
        val tasks: Array<TaskResource> = taskService.getTasks(authentication.name)
        return tasks
    }

    @PostMapping
    fun updateTasks(authentication: Authentication, @Valid @RequestBody resources: Array<TaskResource>) {
        taskService.saveTasks(authentication.name, resources.toList())
    }
}