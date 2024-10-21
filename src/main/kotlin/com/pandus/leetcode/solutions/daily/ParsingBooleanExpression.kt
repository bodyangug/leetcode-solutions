package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/parsing-a-boolean-expression
class ParsingBooleanExpression {
    fun parseBoolExpr(expression: String): Boolean {
        var expression = expression
        while (expression.length > 1) {
            val start = max(
                expression.lastIndexOf('!'),
                max(
                    expression.lastIndexOf('&'),
                    expression.lastIndexOf('|')
                )
            )
            val end = expression.indexOf(')', start)
            val subExpr = expression.substring(start, end + 1)
            val result = evaluateSubExpr(subExpr)
            expression = expression.substring(0, start) +
                    result + expression.substring(end + 1)
        }
        return expression[0] == 't'
    }

    private fun evaluateSubExpr(subExpr: String): Char {
        val op = subExpr[0]
        val values = subExpr.substring(2, subExpr.length - 1)
        // Apply logical operations based on the operator
        if (op == '!') return if (values[0] == 't') 'f' else 't'
        if (op == '&') return if (values.contains("f")) 'f' else 't'
        if (op == '|') return if (values.contains("t")) 't' else 'f'
        return 'f'
    }
}
