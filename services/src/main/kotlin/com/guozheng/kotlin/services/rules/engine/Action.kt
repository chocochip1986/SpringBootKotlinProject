package com.guozheng.kotlin.services.rules.engine

@FunctionalInterface
interface Action {
    fun execute()
}