package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/design-spreadsheet
class DesignSpreadsheet(rows: Int) {
    private val cells = mutableMapOf<String, Int>()

    fun setCell(cell: String, value: Int) {
        cells[cell] = value
    }

    fun resetCell(cell: String) {
        cells.remove(cell)
        // Or alternatively: cells[cell] = 0
    }

    fun getValue(formula: String): Int {
        // Remove the '=' prefix and split by '+'
        val expression = formula.substring(1)
        val parts = expression.split("+")

        val operand1 = parseOperand(parts[0])
        val operand2 = parseOperand(parts[1])

        return operand1 + operand2
    }

    private fun parseOperand(operand: String): Int {
        return if (operand.first().isLetter()) {
            // It's a cell reference
            getCellValue(operand)
        } else {
            // It's a number
            operand.toInt()
        }
    }

    private fun getCellValue(cell: String): Int {
        return cells[cell] ?: 0
    }
}
