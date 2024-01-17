package com.example.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Customer(
    @BsonId
    val id: ObjectId?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    //val lastModified: Instant?,
    //val createDate: LocalDate?,
    //val dog: Dog?
)
