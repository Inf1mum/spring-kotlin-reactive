package com.example.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("mongodb")
data class MongoProperty(
    val url: String,
    val database: String,
    val customerCollection: String
)

