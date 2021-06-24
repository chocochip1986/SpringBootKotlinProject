package com.guozheng.kotlin.domain.model.entities

import com.guozheng.kotlin.domain.model.entities.enums.Operator
import com.guozheng.kotlin.domain.model.entities.enums.Parameter
import java.time.LocalDateTime
import java.util.function.Predicate

class Condition(
    var id: Long? = null,
    var criterionId: Long? = null,
    var parameter: Parameter? = null,
    var operator: Operator? = null,
    var value: String? = null,
    var priority: Int? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var deletedAt: LocalDateTime? = null
) {
    fun <T> buildThisCondition(): Predicate<T> {
        return Predicate{ t ->
            true
        }

    }
}
