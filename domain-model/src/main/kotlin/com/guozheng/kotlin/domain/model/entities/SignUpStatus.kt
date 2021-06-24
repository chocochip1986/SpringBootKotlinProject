package com.guozheng.kotlin.domain.model.entities

import java.time.LocalDateTime

class SignUpStatus(
    var id: Long? = null,
    var personId: Long? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var deletedAt: LocalDateTime? = null
) {
}