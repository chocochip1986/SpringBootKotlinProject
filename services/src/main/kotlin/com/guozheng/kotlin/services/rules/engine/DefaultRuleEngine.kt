package com.guozheng.kotlin.services.rules.engine

class DefaultRuleEngine<C>: RuleEngine<C> {
    override fun trigger(rules: Rules<C>, c: C) {
        if (rules.isEmpty()) {
            println("No rules to run on")
        } else {
            val itr = rules.getIterator()
            while(itr.hasNext()) {
                var rule: Rule<C> = itr.next()
                if ( rule.evaluate(c) ) {
                    for ( action in rule.getActions() ) {
                        action.execute()
                    }
                } else {
                    println("Rule ${rule.getRuleName()} failed")
                }
            }
        }
    }
}