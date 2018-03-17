package com.tak.repository.entity

import com.tak.rest.resources.UserResource
import javax.persistence.*

@Entity
@Table(name="users")
data class UserEntity (

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long?,

        @Column(unique = true)
        val username: String,

        val password: String
){
    companion object Factory {
        fun fromResource(resource: UserResource) : UserEntity{
            return UserEntity(resource.id, resource.username, resource.password)
        }
    }
}