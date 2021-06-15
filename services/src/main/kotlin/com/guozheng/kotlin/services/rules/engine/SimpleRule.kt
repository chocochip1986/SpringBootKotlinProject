package com.guozheng.kotlin.services.rules.engine

class SimpleRule<C>(
    private val name: String,
    private val description: String, private val priority: Int, private val condition: Condition<C>, private val actions: List<Action>) : Rule<C> {
    override fun getPriority(): Int {
        return this.priority
    }

    override fun getCondition(): Condition<C> {
        return this.condition
    }

    override fun getActions(): List<Action> {
        return this.actions
    }

    override fun evaluate(c: C): Boolean {
        return this.evaluate(c)
    }

    override fun getRuleName(): String {
        return this.name
    }

    override fun getRuleDescription(): String {
        return this.description
    }

    override fun compareTo(other: Rule<C>): Int {
        if (this.priority < other.getPriority()) {
            return -1
        } else {
            return if (this.priority > other.getPriority()) 1 else 0
        }
    }

    override fun execute() {
        for (action in actions) {
            action.execute()
        }
    }
}