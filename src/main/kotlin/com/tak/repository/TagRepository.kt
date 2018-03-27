package com.tak.repository

import com.tak.repository.entity.TagEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository : CrudRepository<TagEntity, String> {
    fun findByTaskId(id: String): List<TagEntity>
    fun findByValue(value: String): List<TagEntity>
}