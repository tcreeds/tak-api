
package com.tak

import com.tak.repository.UserDataRepository
import com.tak.rest.resources.TagResource
import com.tak.rest.resources.TaskResource
import com.tak.service.TaskService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

class TaskServiceTest{

    @MockBean
    lateinit var repository: UserDataRepository

    //lateinit var taskService: TaskService

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(javaClass)
        //taskService = TaskService(taskRepository, tagRepository)
    }

    @Test
    fun shouldSaveTasks(){

            val tag: TagResource = TagResource("testtag", "testing", "testing 123")
            val task: TaskResource = TaskResource("test", "Test Task", "open", arrayOf(tag).toList())
            //taskService.saveTask(task)

    }

}
