package com.tak.rest.resources

import com.fasterxml.jackson.annotation.JsonProperty
import com.tak.repository.entity.TaskEntity
import javax.validation.constraints.NotBlank

data class TaskResource(
        @JsonProperty
        @get:NotBlank
        val id: String = "",

        @JsonProperty
        @get:NotBlank
        val name: String = "",

        @JsonProperty
        @get:NotBlank
        val tags: List<TagResource> = listOf()
){
        companion object {
                fun fromEntity(entity: TaskEntity): TaskResource {
                        return TaskResource(entity.id, entity.name, TagResource.fromEntities(entity.tags))
                }

                fun fromEntities(entities: List<TaskEntity>) : List<TaskResource> {
                        return entities.map{ TaskResource.fromEntity (it) }
                }
        }
}