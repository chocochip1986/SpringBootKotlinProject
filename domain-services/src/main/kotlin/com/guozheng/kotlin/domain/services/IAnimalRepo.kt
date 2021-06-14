package com.guozheng.kotlin.domain.services

import com.guozheng.kotlin.domain.model.entities.Animal

interface IAnimalRepo {
    fun findById(id: Long): Animal?

    fun findAll(): List<Animal>?

    fun save(animal: Animal): Animal

    fun delete(animal: Animal)
}