package com.tiarebalbi.springdatakotlinnullablequery.exception

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CarMaintenanceRepository : MongoRepository<CarMaintenance, String> {

    @Query("{_id: ?0}")
    fun findByNullableId(id: String): Car?
}
