package com.tiarebalbi.springdatakotlinnullablequery

import org.assertj.core.api.Assertions
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataMongoTest
class CustomModelRepositoryTest {

    @Autowired
    private lateinit var customModelRepository: CustomModelRepository

    @After
    fun tearDown() {
        this.customModelRepository.deleteAll()
    }

    @Test
    fun `should fail with if model is wrong`() {
        this.customModelRepository.save(CustomModel(
            id = "1",
            number = "2"
        ))

        val valor1 = this.customModelRepository.findByNullableId("1")
        Assertions.assertThat(valor1).isNotNull()

        val valor2 = this.customModelRepository.findByNullableId("2")
        Assertions.assertThat(valor2).isNull()
    }

}