package com.tiarebalbi.springdatakotlinnullablequery.exception

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document
data class Car(
    @Id val id: String? = null,
    val model: String,
    val brand: String,
    val year: Int,
    val color: String,
    @Indexed(unique = true) val identification: String,
    val history: MutableList<CarDetails> = mutableListOf(),
    val status: Boolean = true,
    var currentMiles: Int = 0,
    @LastModifiedDate var lastModified: LocalDateTime? = null
)

data class CarDetails(
    val token: String = UUID.randomUUID().toString(),
    @Indexed(direction = DESCENDING) val usageStart: LocalDateTime = LocalDateTime.now(),
    val deliveredDate: LocalDateTime? = null,
    val user: UserDetails,
    val initialMiles: Int,
    val finalMile: Int? = null,
    var usedMiles: Int = 0
)

data class UserDetails(val name: String, val id: String)
