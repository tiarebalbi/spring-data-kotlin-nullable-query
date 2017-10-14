package com.tiarebalbi.springdatakotlinnullablequery

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Model(
  @Id val id: String? = null,
  @Indexed val name: String,
  val description: String
)