package com.guozheng.kotlin.services

import com.guozheng.kotlin.domain.model.entities.Animal
import com.guozheng.kotlin.domain.services.IAnimalRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class AnimalService(
    @Autowired private val iAnimalRepo: IAnimalRepo) {

    fun findById(id: Long): Animal? {
        return iAnimalRepo.findById(id)
    }

    fun save(animal: Animal): Animal {
        return iAnimalRepo.save(animal)
    }

    fun update(animal: Animal): Animal? {
        val id: Long = animal.id ?: return null
        var existingAnimal = iAnimalRepo.findById(id) ?: return null

        existingAnimal.name = animal.name
        return iAnimalRepo.save(existingAnimal)
    }

    fun delete(animal: Animal) {
        val id: Long = animal.id ?: return
        var existingAnimal = iAnimalRepo.findById(id) ?: return

        existingAnimal.deletedAt = LocalDateTime.now()
        iAnimalRepo.save(existingAnimal)
    }
}