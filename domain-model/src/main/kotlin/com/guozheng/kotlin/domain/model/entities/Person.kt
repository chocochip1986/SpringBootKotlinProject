package com.guozheng.kotlin.domain.model.entities

import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@Data
@NoArgsConstructor
class Person(
    var id: Long? = null,
    var name: String? = null,
    var nationality: String? = null,
    var deathDate: LocalDateTime? = null,
    var birthDate: LocalDateTime? = null,
    var income: Double? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var deletedAt: LocalDateTime? = null) {
    constructor(name: String?) : this() {
        this.id = null
        this.name = name
    }

    constructor(id: Long?, name: String?) : this(id, name, null, null, null)
}