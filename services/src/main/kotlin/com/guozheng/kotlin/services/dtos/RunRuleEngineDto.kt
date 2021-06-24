package com.guozheng.kotlin.services.dtos

import com.guozheng.kotlin.domain.model.entities.Rule

class RunRuleEngineDto(private val metadata: RunRuleEngineMetadata) {
    var rules: List<Rule> = mutableListOf()
}