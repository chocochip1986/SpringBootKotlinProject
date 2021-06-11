package com.guozheng.kotlin.infra.jpa.entities

import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.hibernate.envers.Audited
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Builder
@Data
@NoArgsConstructor
@Audited
@EntityListeners(AuditingEntityListener::class)
@Where(clause = "DELETED_AT IS NULL")
@Table(name = "animals")
class AnimalEntity (
    @Column var name: String?,
    createdAt: LocalDateTime?,
    updatedAt: LocalDateTime?,
    deletedAt: LocalDateTime?,
    id: Long?
) : BaseEntity(id, createdAt, updatedAt, deletedAt)