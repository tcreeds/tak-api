package com.tak.repository.entity

import com.tak.rest.resources.TaskResource
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name="task")
data class TaskEntity(

        @Id
        val id: String,

        val name: String,

        @OneToMany(mappedBy = "task")
        val tags: List<TagEntity> = listOf()

){

        companion object Mapper {
                fun fromResource(taskResource: TaskResource) : TaskEntity {

                        return TaskEntity(taskResource.id,
                                taskResource.name)
                }

                fun fromResources(resources: List<TaskResource>) : List<TaskEntity> {
                        return resources.map{
                                fromResource(it)
                        }
                }
        }

}