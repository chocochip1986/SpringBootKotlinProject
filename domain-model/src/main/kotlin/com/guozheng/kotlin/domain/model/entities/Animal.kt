package com.guozheng.kotlin.domain.model.entities

import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@Data
@NoArgsConstructor
@Builder
class Animal(
    var id: Long? = null,
    var name: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var deletedAt: LocalDateTime? = null) {
    constructor(name: String?) : this() {
        this.id = null
        this.name = name
    }

    constructor(id: Long?, name: String?) : this(id, name, null, null, null)
}