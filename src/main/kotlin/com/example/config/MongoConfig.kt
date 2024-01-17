package com.example.config

import com.example.entity.Customer
import com.example.property.MongoProperty
import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoConfig(
    private val mongoProperty: MongoProperty
) {

    @Bean
    fun mongoClient(): MongoClient {
        return MongoClient.create(mongoProperty.url)
    }

    @Bean
    fun mongoDatabase(mongoClient: MongoClient): MongoDatabase {
        return mongoClient.getDatabase(mongoProperty.database)
    }

    @Bean
    fun customerCollection(mongoDatabase: MongoDatabase): MongoCollection<Customer> {
        return mongoDatabase.getCollection<Customer>(mongoProperty.customerCollection)
    }
}
