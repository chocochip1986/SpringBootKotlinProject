package com.guozheng.kotlin.infra.jpa.mappers

import com.guozheng.kotlin.domain.model.entities.Animal
import com.guozheng.kotlin.domain.model.entities.Person
import com.guozheng.kotlin.infra.jpa.entities.AnimalEntity
import com.guozheng.kotlin.infra.jpa.entities.PersonEntity

class AnimalMapper {
    companion object {
        fun mapEntityToModel(animalEntity: AnimalEntity): Animal {
            return Animal(animalEntity.id, animalEntity.name, animalEntity.createdAt, animalEntity.updatedAt, animalEntity.deletedAt)
        }

        fun mapModelToEntity(animal: Animal): AnimalEntity {
            return AnimalEntity(animal.name, animal.createdAt, animal.updatedAt, animal.deletedAt, animal.id)
        }
    }
}

class PersonMapper {
    companion object {
        fun mapEntityToModel(personEntity: PersonEntity): Person {
            return Person(personEntity.id, personEntity.name, personEntity.createdAt, personEntity.updatedAt, personEntity.deletedAt)
        }

        fun mapModelToEntity(person: Person): PersonEntity {
            return PersonEntity(person.name, person.createdAt, person.updatedAt, person.deletedAt, person.id)
        }
    }
}