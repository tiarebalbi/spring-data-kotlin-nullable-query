package com.tiarebalbi.springdatakotlinnullablequery

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@EnableMongoAuditing
@SpringBootApplication
class SpringDataKotlinNullableQueryApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringDataKotlinNullableQueryApplication::class.java, *args)
}
