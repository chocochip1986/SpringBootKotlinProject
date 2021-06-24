package com.guozheng.kotlin.domain.model.entities

import java.time.LocalDateTime

class Rule(
    var id: Long? = null,
    var ruleType: String? = null,
    var description: String? = null,
    var priority: Int? = null,
    var criteria: List<Criterion>? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var deletedAt: LocalDateTime? = null)