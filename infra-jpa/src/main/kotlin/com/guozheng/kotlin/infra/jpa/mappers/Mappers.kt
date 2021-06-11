package com.guozheng.kotlin.infra.jpa.mappers

import com.guozheng.kotlin.domain.model.entities.Animal
import com.guozheng.kotlin.infra.jpa.entities.AnimalEntity

class AnimalMapper {
    companion object {
        fun mapEntityToModel(animalEntity: AnimalEntity): Animal {
            return Animal(animalEntity.id, animalEntity.name)
        }

        fun mapModelToEntity(animal: Animal): AnimalEntity {
            return AnimalEntity(animal.id, animal.name)
        }
    }
}