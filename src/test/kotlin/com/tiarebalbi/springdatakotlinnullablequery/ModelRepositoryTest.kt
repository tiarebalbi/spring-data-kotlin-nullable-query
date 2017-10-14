package com.tiarebalbi.springdatakotlinnullablequery

import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataMongoTest
class ModelRepositoryTest {

  @Autowired
  private lateinit var modelRepository: ModelRepository

  private val model = Model(
    name = "Model 1",
    description = "Description..."
  )

  @After
  fun tearDown() {
    this.modelRepository.deleteAll()
  }

  @Test
  fun `should find a model by name`() {
    // given
    this.modelRepository.save(this.model.copy())

    // when
    val result = this.modelRepository.findByName("Model 1")

    // then
    assertThat(result).isNotNull()
    assertThat(result?.name).isEqualTo("Model 1")
  }

  @Test
  fun `should try find a invalid model and receive null`() {
    // given
    this.modelRepository.save(this.model.copy())

    // when
    val result = this.modelRepository.findByName("Invalid")

    // then
    assertThat(result).isNull()
  }

  @Test
  fun `should find by id`() {
// given
    this.modelRepository.save(this.model.copy(id = "1"))

    // when
    val result = this.modelRepository.findByNullableId("1")

    // then
    assertThat(result).isNotNull()
    assertThat(result?.id).isEqualTo("1")
  }

  @Test
  fun `should find by id and receive null`() {
    // given
    this.modelRepository.save(this.model.copy())

    // when
    val result = this.modelRepository.findByNullableId("Invalid")

    // then
    assertThat(result).isNull()
  }
}