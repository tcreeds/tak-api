package com.tak.rest.resources

import com.fasterxml.jackson.annotation.JsonProperty
import com.tak.repository.entity.TagEntity
import org.hibernate.validator.constraints.NotBlank

data class TagResource(
        @JsonProperty
        @get:NotBlank
        val id: String ="",

        @JsonProperty
        @get:NotBlank
        val type: String = "",

        @JsonProperty
        @get:NotBlank
        val value: String = ""
){
        companion object Factory {
                fun fromEntity(entity: TagEntity) : TagResource {
                        return TagResource(entity.id, entity.type, entity.value)
                }

                fun fromEntities(entities: List<TagEntity>) : List<TagResource> {
                        return entities.map { TagResource.fromEntity(it) }
                }
        }
}