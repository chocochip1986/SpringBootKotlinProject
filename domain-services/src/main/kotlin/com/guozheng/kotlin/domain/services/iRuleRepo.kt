package com.guozheng.kotlin.domain.services

import com.guozheng.kotlin.domain.model.entities.Rule

interface IRuleRepo {
    fun retrieveRules(): List<Rule>
}