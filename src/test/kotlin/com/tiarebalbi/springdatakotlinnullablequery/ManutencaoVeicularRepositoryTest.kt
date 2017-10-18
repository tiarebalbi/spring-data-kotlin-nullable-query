package com.tiarebalbi.springdatakotlinnullablequery

import com.tiarebalbi.springdatakotlinnullablequery.exception.CarMaintenance
import com.tiarebalbi.springdatakotlinnullablequery.exception.CarMaintenanceRepository
import com.tiarebalbi.springdatakotlinnullablequery.exception.DetalhesVeiculo
import org.assertj.core.api.Assertions
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataMongoTest
class ManutencaoVeicularRepositoryTest {

    @Autowired
    private lateinit var carMaintenanceRepository: CarMaintenanceRepository

    private val manutencaoVeicular = CarMaintenance(
        car = DetalhesVeiculo("model", "brand", "color", "1"),
        store = "Store 1",
        summary = "Notes"
    )

    @After
    fun tearDown() {
        this.carMaintenanceRepository.deleteAll()
    }

    @Test
    fun `should search nullable value`() {
        this.carMaintenanceRepository.save(this.manutencaoVeicular.copy(
            id = "1"
        ))

        val valor1 = this.carMaintenanceRepository.findByNullableId("1")
        Assertions.assertThat(valor1).isNotNull()
        val valor2 = this.carMaintenanceRepository.findByNullableId("2")
        Assertions.assertThat(valor2).isNull()
    }

}