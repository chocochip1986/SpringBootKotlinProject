package com.guozheng.kotlin.services.rules.engine

@FunctionalInterface
interface Condition<C> {
    fun evaluate(c: C): Boolean
}