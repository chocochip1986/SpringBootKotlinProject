package com.guozheng.kotlin.services

import com.guozheng.kotlin.domain.model.entities.Animal
import com.guozheng.kotlin.domain.services.IAnimalRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AnimalService(
    @Autowired private val iAnimalRepo: IAnimalRepo) {

    fun findById(id: Long): Animal? {
        return iAnimalRepo.findById(id)
    }

    fun save(animal: Animal): Animal {
        return iAnimalRepo.save(animal)
    }
}