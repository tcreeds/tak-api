/*
package com.tak

import com.tak.repository.TaskRepository
import com.tak.rest.resources.TagResource
import com.tak.rest.resources.TaskResource
import com.tak.service.TaskService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TaskServiceTest{

         \
        @Before
        fun setup(){

        }

    @Test
    fun shouldSaveTasks(){
            val tag: TagResource = TagResource("testtag", "testing", "testing 123")
            val task: TaskResource = TaskResource("test", "Test Task", arrayOf(tag).toList())
            taskService.updateTasks(arrayOf(task).toList())

    }

}*/
