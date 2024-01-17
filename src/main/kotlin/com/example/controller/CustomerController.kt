package com.example.controller

import com.example.entity.Customer
import com.example.repository.CustomerRepository
import com.mongodb.kotlin.client.coroutine.FindFlow
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.coRouter

@RestController
class CustomerController(
    private val customerRepository: CustomerRepository
) {
    /*@Bean
    fun http() = coRouter {
        GET("/customers") {
            ServerResponse.ok().bodyAndAwait(customerRepository.findAll())
        }
    }*/

    @GetMapping("/customers")
    suspend fun findCustomers(): Flow<Customer> {
        return customerRepository.findAll()
    }
}
