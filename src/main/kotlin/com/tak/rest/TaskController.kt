package com.tak.rest

import com.tak.rest.resources.TaskResource
import com.tak.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = "/tasks")
class TaskController(

        @Autowired
        val taskService: TaskService

) {
    @GetMapping
    fun getTasks() : Array<TaskResource> {
        val tasks: Array<TaskResource> = taskService.getTasks()
        return tasks
    }

    @PostMapping
    fun updateTasks(@Valid @RequestBody resources: Array<TaskResource>) {
        for (task in resources) taskService.saveTask(task)
    }
}