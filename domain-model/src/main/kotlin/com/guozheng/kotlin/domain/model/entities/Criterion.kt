package com.guozheng.kotlin.domain.model.entities

import java.time.LocalDateTime

class Criterion(
    var id: Long? = null,
    var ruleId: Long? = null,
    var description: String? = null,
    var priority: Int? = null,
    var conditions: List<Condition>? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var deletedAt: LocalDateTime? = null
)