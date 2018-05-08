package com.tak.repository.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName="tak")
class UserDataEntity (

        @DynamoDBHashKey
        var username: String = "",

        @DynamoDBAttribute
        var password: String = "",

        @DynamoDBAttribute
        var tasks: List<TaskEntity> = listOf()
)
