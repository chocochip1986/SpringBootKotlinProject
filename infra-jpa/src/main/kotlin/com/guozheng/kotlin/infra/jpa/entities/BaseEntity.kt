package com.guozheng.kotlin.infra.jpa.entities

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
    @CreatedDate @Column var createdAt: LocalDateTime?,
    @LastModifiedDate @Column var updatedAt: LocalDateTime?) {

    @PrePersist
    @PreUpdate
    @PreRemove
    fun onUpdate() {
        this.updatedAt = LocalDateTime.now()
    }
}