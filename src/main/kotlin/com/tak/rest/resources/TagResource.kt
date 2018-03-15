package com.tak.rest.resources

import com.fasterxml.jackson.annotation.JsonProperty
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
)