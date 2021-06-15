package com.guozheng.kotlin.services.rules.engine

import java.util.*

class Rules<C>(private var rules: TreeSet<Rule<C>> = TreeSet()) {
    fun addRules(vararg rules: Rule<C>) {
        Collections.addAll(this.rules, *rules)
    }

    fun addRule(rule: Rule<C>) {
        if (this.rules.contains(rule)) {
        } else {
            this.rules.add(rule)
        }
    }

    fun removeRule(rule: Rule<C>): Boolean {
        return this.rules.remove(rule)
    }

    fun findRuleByName(rule: Rule<C>): Rule<C> {
        return this.rules.filter { r -> r.getRuleName().equals(rule.getRuleName()) }.first()
    }

    fun isEmpty(): Boolean {
        return this.rules.isEmpty()
    }

    fun purge() {
        this.rules.clear()
    }

    fun getIterator(): Iterator<Rule<C>> {
        return this.rules.iterator()
    }
}