package com.guozheng.kotlin.infra.jpa.repo.impl

import com.guozheng.kotlin.domain.model.entities.Animal
import com.guozheng.kotlin.domain.services.IAnimalRepo
import com.guozheng.kotlin.infra.jpa.entities.AnimalEntity
import com.guozheng.kotlin.infra.jpa.mappers.AnimalMapper
import com.guozheng.kotlin.infra.jpa.repositories.AnimalEntityJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class AnimalJpaRepoImpl(
    @Autowired private val animalEntityJpaRepository: AnimalEntityJpaRepository
    ) : IAnimalRepo{
    override fun findById(id: Long): Animal? {
        val entity: AnimalEntity = animalEntityJpaRepository.findById(id).orElse(null) ?: return null;
        val animal: Animal = AnimalMapper.mapEntityToModel(entity);
        return animal;
    }

    override fun save(animal: Animal): Animal {
        val entity: AnimalEntity = AnimalMapper.mapModelToEntity(animal)
        val savedEntity: AnimalEntity = animalEntityJpaRepository.save(entity)
        return AnimalMapper.mapEntityToModel(savedEntity)
    }

    override fun delete(animal: Animal) {
        val entity: AnimalEntity = AnimalMapper.mapModelToEntity(animal)
        animalEntityJpaRepository.delete(entity)
    }
}