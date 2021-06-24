package com.guozheng.kotlin.domain.model.entities.functions

import com.guozheng.kotlin.domain.model.entities.enums.Operator
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.util.function.Function
import java.util.function.Predicate
import java.util.function.Supplier

class DateComparator {
    fun createFn(operator: Operator, value: LocalDateTime): Predicate<LocalDateTime> {
        when(operator) {
            Operator.EQUAL_TO -> {
                return Predicate { operand -> operand == value }
            }
            Operator.GREATER_THAN -> {
                return Predicate { operand -> operand.isAfter(value) }
            }
            Operator.LESSER_THAN -> {
                return Predicate { operand -> operand.isBefore(value) }
            }
            Operator.NOT_EQUAL_TO -> {
                return Predicate { operand -> operand != value }
            }
            else -> throw RuntimeException()
        }
    }
}


class FunctionOperator {
    fun operationForDateComparison(operator: Operator, operand1: LocalDateTime?, operand2: LocalDateTime?): Supplier<Boolean> {
        if (operand1 != null) {
            when(operator) {
                Operator.EQUAL_TO -> {
                    return Supplier { operand1 == operand2 }
                }
                Operator.GREATER_THAN -> {
                    return Supplier { operand1.isAfter(operand2) }
                }
                Operator.LESSER_THAN -> {
                    return Supplier { operand1.isBefore(operand2) }
                }
                Operator.NOT_EQUAL_TO -> {
                    return Supplier { operand1 != operand2 }
                }
                else -> throw RuntimeException("Unsupported!")
            }
        } else {
            return Supplier { true }
        }
    }

    fun operationForStringComparison(operator: Operator, operand1: String?, operand2: String?): Supplier<Boolean> {
        if ( operand1 != null ) {
            when(operator) {
                Operator.EQUAL_TO -> {
                    return Supplier { operand1.equals(operand2) }
                }
                Operator.NOT_EQUAL_TO -> {
                    return Supplier { !operand1.equals(operand2) }
                }
                else -> throw RuntimeException("Unsupported!")
            }
        } else {
            return Supplier { true }
        }
    }
}