package com.tak.rest.resources

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotBlank

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
)