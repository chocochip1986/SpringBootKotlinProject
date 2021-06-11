package com.guozheng.kotlin.infra.jpa.entities

import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Builder
@Data
@NoArgsConstructor
class PersonEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column
    var name: String?
)