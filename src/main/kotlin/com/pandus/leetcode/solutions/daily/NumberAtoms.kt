package com.pandus.leetcode.solutions.daily

import java.util.TreeMap

// Reference: https://leetcode.com/problems/number-of-atoms
class NumberAtoms {
    var index: Int = 0

    fun countOfAtoms(formula: String): String {
        val finalMap = parseFormula(formula)

        // Sort the final map
        val sortedMap = TreeMap(finalMap)

        // Generate the answer string
        val ans = StringBuilder()
        for (atom in sortedMap.keys) {
            ans.append(atom)
            if (sortedMap[atom]!! > 1) {
                ans.append(sortedMap[atom])
            }
        }

        return ans.toString()
    }

    // Recursively parse the formula
    private fun parseFormula(formula: String): Map<String, Int> {
        // Local variable
        val currMap: MutableMap<String, Int> = HashMap()
        var currAtom = ""
        var currCount = ""

        // Iterate until the end of the formula
        while (index < formula.length) {
            // UPPERCASE LETTER
            if (Character.isUpperCase(formula[index])) {
                if (currAtom.isNotEmpty()) {
                    if (currCount.isEmpty()) {
                        currMap[currAtom] = currMap.getOrDefault(currAtom, 0) + 1
                    } else {
                        currMap[currAtom] = currMap.getOrDefault(currAtom, 0) + currCount.toInt()
                    }
                }

                currAtom = formula[index].toString()
                currCount = ""
                index++
            } else if (Character.isLowerCase(formula[index])) {
                currAtom += formula[index]
                index++
            } else if (Character.isDigit(formula[index])) {
                currCount += formula[index]
                index++
            } else if (formula[index] == '(') {
                index++
                val nestedMap = parseFormula(formula)
                for (atom in nestedMap.keys) {
                    currMap[atom] = currMap.getOrDefault(atom, 0) + nestedMap[atom]!!
                }
            } else if (formula[index] == ')') {
                // Save the last atom and count of nested formula
                if (currAtom.isNotEmpty()) {
                    if (currCount.isEmpty()) {
                        currMap[currAtom] = currMap.getOrDefault(currAtom, 0) + 1
                    } else {
                        currMap[currAtom] = currMap.getOrDefault(currAtom, 0) + currCount.toInt()
                    }
                }

                index++
                val multiplier = StringBuilder()
                while (index < formula.length &&
                    Character.isDigit(formula[index])
                ) {
                    multiplier.append(formula[index])
                    index++
                }
                if (multiplier.isNotEmpty()) {
                    val mult = multiplier.toString().toInt()
                    for (atom in currMap.keys) {
                        currMap[atom] = currMap[atom]!! * mult
                    }
                }

                return currMap
            }
        }

        // Save the last atom and count
        if (currAtom.isNotEmpty()) {
            if (currCount.isEmpty()) {
                currMap[currAtom] = currMap.getOrDefault(currAtom, 0) + 1
            } else {
                currMap[currAtom] = currMap.getOrDefault(currAtom, 0) + currCount.toInt()
            }
        }

        return currMap
    }
}
