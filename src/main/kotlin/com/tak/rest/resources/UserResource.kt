package com.tak.rest.resources

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank

data class UserResource(
        @JsonProperty
        val id: String? = null,

        @JsonProperty
        val username: String = "",

        @JsonProperty
        val password: String = ""
)