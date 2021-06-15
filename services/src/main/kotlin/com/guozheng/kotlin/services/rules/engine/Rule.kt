package com.guozheng.kotlin.services.rules.engine

interface Rule<C> : Comparable<Rule<C>> {
    fun evaluate(c: C): Boolean
    fun execute()
    fun getCondition(): Condition<C>
    fun getActions(): List<Action>
    fun getRuleName(): String
    fun getRuleDescription(): String
    fun getPriority(): Int
}