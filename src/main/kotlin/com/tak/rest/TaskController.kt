package com.tak.rest

import com.tak.rest.resources.TaskResource
import com.tak.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = "/")
class TaskController(

        @Autowired
        val taskService: TaskService

) {
    @GetMapping(value = "/tasks")
    fun getTask() : String {
        return "gotem"
    }

    @PostMapping(value = "/tasks")
    fun updateTasks(@Valid @RequestBody resources: Array<TaskResource>) {
        print(resources)
        for (task in resources) taskService.saveTask(task)
    }
}