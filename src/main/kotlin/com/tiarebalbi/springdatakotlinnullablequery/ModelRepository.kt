package com.tiarebalbi.springdatakotlinnullablequery

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ModelRepository : MongoRepository<Model, String> {

  @Query("{_id: ?0}")
  fun findByNullableId(id: String): Model?

  fun findByName(name: String): Model?

}