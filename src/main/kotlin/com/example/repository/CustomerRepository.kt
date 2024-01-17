package com.example.repository

import com.example.entity.Customer
import com.mongodb.kotlin.client.coroutine.FindFlow
import com.mongodb.kotlin.client.coroutine.MongoCollection
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Repository

@Repository
class CustomerRepository(
    private val customerCollection: MongoCollection<Customer>
) {
    fun findAll(): Flow<Customer> {
        return customerCollection.find()
    }
}
