package com.tiarebalbi.springdatakotlinnullablequery.exception

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document
data class CarMaintenance(
    @Id val id: String? = null,
    var car: DetalhesVeiculo? = null,
    val summary: String,
    val billNumber: String = "",
    val notes: String = "",
    val store: String,
    val total: BigDecimal = BigDecimal.ZERO,
    @Indexed val milesNextVisit: Int? = null,
    @Indexed val dateNextVisit: LocalDateTime? = null,
    @Indexed(direction = DESCENDING) @CreatedDate val createdDate: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate var lastModifiedDate: LocalDateTime? = null
)

data class DetalhesVeiculo(
    val model: String,
    val brand: String,
    val color: String,
    val id: String
)