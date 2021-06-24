package com.guozheng.kotlin.domain.model.entities.functions

import com.guozheng.kotlin.domain.model.entities.Data
import com.guozheng.kotlin.domain.model.entities.Person
import com.guozheng.kotlin.domain.model.entities.enums.Operator
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.util.function.Function

sealed interface FunctionRule<T> {
    fun create(): Function<T, Boolean>
}

class baseRuleFunction<T> : FunctionRule<T> {
    override fun create(): Function<T, Boolean> {
        return Function { t: T -> throw RuntimeException() }
    }
}

class LivingStatusRule(private val value: LocalDateTime, private val operator: Operator) : FunctionRule<Data> {
    override fun create(): Function<Data, Boolean> {
        return Function { data ->
            foo(data.person.deathDate, operator, ::select)
        }
    }

    fun foo(operand1: LocalDateTime?, operator: Operator, fn: (person: LocalDateTime?, operator: Operator) -> Boolean): Boolean {
        return fn(operand1, operator)
    }

    fun select(operand: LocalDateTime?, operator: Operator): Boolean {
        when(operator) {
            Operator.EQUAL_TO -> {
                return operand == value
            }
            Operator.GREATER_THAN -> {
                return operand?.isAfter(value) ?: true
            }
            Operator.LESSER_THAN -> {
                return operand?.isBefore(value) ?: true
            }
            Operator.NOT_EQUAL_TO -> {
                return operand != value
            }
            else -> throw RuntimeException()
        }
    }
}

class NationalityRule(private val value: String, private val operator: Operator): FunctionRule<Data> {
    override fun create(): Function<Data, Boolean> {
        return Function { data ->
            when(operator) {
                Operator.EQUAL_TO -> {
                    data.person.nationality.equals(value)
                }
                Operator.NOT_EQUAL_TO -> {
                    !data.person.nationality.equals(value)
                }
                else -> throw RuntimeException()
            }
        }
    }
}

class SignUpStatusRule(private val value: LocalDateTime, private val operator: Operator): FunctionRule<Data> {
    override fun create(): Function<Data, Boolean> {
        return Function { data ->
            foo(data.signUpStatus.createdAt, operator, ::select)
        }
    }

    fun foo(operand1: LocalDateTime?, operator: Operator, fn: (person: LocalDateTime?, operator: Operator) -> Boolean): Boolean {
        return fn(operand1, operator)
    }

    fun select(operand: LocalDateTime?, operator: Operator): Boolean {
        when(operator) {
            Operator.EQUAL_TO -> {
                return operand == value
            }
            Operator.GREATER_THAN -> {
                return operand?.isAfter(value) ?: true
            }
            Operator.LESSER_THAN -> {
                return operand?.isBefore(value) ?: true
            }
            Operator.NOT_EQUAL_TO -> {
                return operand != value
            }
            else -> throw RuntimeException()
        }
    }
}

