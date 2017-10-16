package com.tiarebalbi.springdatakotlinnullablequery

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CustomModelRepository : MongoRepository<CustomModel, String> {

    @Query("{_id: ?0}")
    fun findByNullableId(id: String): Model?

}