package com.tak.rest.resources

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotBlank

data class UserResource(
        @JsonProperty
        val id: Long? = null,

        @JsonProperty
        @get:NotBlank
        val username: String = "",

        @JsonProperty
        @get:NotBlank
        val password: String = ""
)