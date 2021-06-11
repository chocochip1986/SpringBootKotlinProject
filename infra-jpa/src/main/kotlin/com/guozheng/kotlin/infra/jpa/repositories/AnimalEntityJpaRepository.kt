package com.guozheng.kotlin.infra.jpa.repositories

import com.guozheng.kotlin.infra.jpa.entities.AnimalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnimalEntityJpaRepository : JpaRepository<AnimalEntity, Long> {
}