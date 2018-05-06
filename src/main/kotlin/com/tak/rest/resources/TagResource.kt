package com.tak.rest.resources

import com.fasterxml.jackson.annotation.JsonProperty
import com.tak.repository.entity.TagEntity
import javax.validation.constraints.NotBlank

data class TagResource(
        @JsonProperty
        @get:NotBlank
        val id: kotlin.String ="",

        @JsonProperty
        @get:NotBlank
        val type: kotlin.String = "",

        @JsonProperty
        @get:NotBlank
        val value: kotlin.String = ""
){
        companion object Factory {
                private fun fromEntity(entity: TagEntity) : TagResource {
                        return TagResource(entity.id, entity.type, entity.value)
                }

                fun fromEntities(entities: List<TagEntity>) : List<TagResource> {
                        return entities.map { TagResource.fromEntity(it) }
                }
        }
}