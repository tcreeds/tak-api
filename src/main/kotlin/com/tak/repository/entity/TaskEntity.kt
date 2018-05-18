package com.tak.repository.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.tak.rest.resources.TaskResource

@DynamoDBTable(tableName="tasks")
data class TaskEntity(

        @DynamoDBHashKey
        var id: String = "",

        @DynamoDBAttribute
        var name: String = "",

        @DynamoDBAttribute
        var state: String = "",

        @DynamoDBAttribute
        var tags: List<TagEntity>? = listOf()

){
        companion object Mapper {
                fun fromResource(taskResource: TaskResource) : TaskEntity {

                        return TaskEntity(taskResource.id,
                                taskResource.name, taskResource.state, TagEntity.fromResources(taskResource.tags ?: listOf()))
                }

                fun fromResources(resources: List<TaskResource>) : List<TaskEntity> {
                        return resources.map{
                                fromResource(it)
                        }
                }
        }

}