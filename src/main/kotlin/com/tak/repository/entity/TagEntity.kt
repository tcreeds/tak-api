package com.tak.repository.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument
import com.tak.rest.resources.TagResource

@DynamoDBDocument
data class TagEntity(

        @DynamoDBAttribute
        var id: String = "",

        @DynamoDBAttribute
        var type: String = "",

        @DynamoDBAttribute
        var value: String = ""

){

        companion object Factory {
            fun fromResource(resource: TagResource) : TagEntity{
                return TagEntity(resource.id, resource.type, resource.value)
            }

            fun fromResources(resources: List<TagResource>) : List<TagEntity> {
                return resources.map{
                    fromResource(it)
                }
            }
        }
}