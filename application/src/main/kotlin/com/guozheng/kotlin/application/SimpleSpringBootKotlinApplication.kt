package com.guozheng.kotlin.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(
    scanBasePackages =
    ["com.guozheng.kotlin.application",
        "com.guozheng.kotlin.domain.model",
        "com.guozheng.kotlin.domain.services",
        "com.guozheng.kotlin.services",
        "com.guozheng.kotlin.infra.jpa",
        "com.guozheng.kotlin.infra.controller"]
)
@EnableJpaRepositories(basePackages = ["com.guozheng.kotlin.infra.jpa.repositories", "com.guozheng.kotlin.infra.jpa.repo.impl"])
@EntityScan(basePackages = ["com.guozheng.kotlin.infra.jpa.entities"])
class SimpleSpringBootKotlinApplication
fun main(args: Array<String>) {
    try {
        runApplication<SimpleSpringBootKotlinApplication>(*args);
    } catch (e: Exception) {
        e.printStackTrace();
    }
}
