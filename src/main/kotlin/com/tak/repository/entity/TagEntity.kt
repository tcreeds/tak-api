package com.tak.repository.entity

import com.tak.rest.resources.TagResource
import javax.persistence.*

@Entity
@Table(name="tags")
data class TagEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: String,

        @ManyToOne
        @JoinColumn(name="postId", nullable=false)
        val task: TaskEntity,

        val type: String,

        val value: String

){

        companion object Factory {
            fun fromResource(resource: TagResource, task: TaskEntity) : TagEntity{
                return TagEntity(resource.id, task, resource.type, resource.value)
            }

            fun fromResources(resources: List<TagResource>, task: TaskEntity) : List<TagEntity> {
                return resources.map{
                    fromResource(it, task)
                }
            }
        }
}