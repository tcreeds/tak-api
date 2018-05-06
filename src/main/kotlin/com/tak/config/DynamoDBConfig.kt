package com.tak.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import org.springframework.context.annotation.Bean
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile


@Configuration
@EnableDynamoDBRepositories(basePackages= ["com.tak.repository"])
open class DynamoDBConfig {

    @Value("\${aws.dynamodb.endpoint}")
    private val amazonDynamoDBEndpoint: String? = null

    @Bean
    open fun amazonDynamoDB(): AmazonDynamoDB {
        val amazonDynamoDB = AmazonDynamoDBClient(amazonAWSCredentials())
        amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint)
        return amazonDynamoDB
    }

    @Bean
    @Profile("!local")
    open fun amazonAWSCredentials(): AWSCredentials {
        return DefaultAWSCredentialsProviderChain().credentials
    }

    @Bean
    @Profile("local")
    open fun amazonAWSCredentialsLocal(): AWSCredentials {
        return ProfileCredentialsProvider().credentials
    }
}