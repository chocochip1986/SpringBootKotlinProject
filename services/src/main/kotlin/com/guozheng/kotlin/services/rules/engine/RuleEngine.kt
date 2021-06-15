package com.guozheng.kotlin.services.rules.engine

sealed interface RuleEngine<C> {
    fun trigger(rules: Rules<C>, c: C)
}