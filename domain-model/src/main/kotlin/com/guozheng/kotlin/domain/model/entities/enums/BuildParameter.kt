package com.guozheng.kotlin.domain.model.entities.enums

import java.util.function.Predicate

@FunctionalInterface
sealed interface BuildParameter<C> {
    fun buildParameter(c: C): Predicate<C>
}