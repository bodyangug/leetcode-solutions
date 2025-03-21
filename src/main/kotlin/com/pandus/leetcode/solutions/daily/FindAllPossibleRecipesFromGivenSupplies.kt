package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies
class FindAllPossibleRecipesFromGivenSupplies {
    fun findAllRecipes(
        recipes: Array<String>,
        ingredients: List<List<String>>,
        supplies: Array<String>
    ): List<String> {
        val available = supplies.toMutableSet()
        val recipeQueue: Queue<Int> = LinkedList(recipes.indices.toList())
        val createdRecipes = mutableListOf<String>()

        var lastSize = -1
        while (available.size > lastSize) {
            lastSize = available.size
            repeat(recipeQueue.size) {
                val recipeIdx = recipeQueue.poll()
                val recipeIngredients = ingredients[recipeIdx]

                if (recipeIngredients.all { it in available }) {
                    val recipe = recipes[recipeIdx]
                    available.add(recipe)
                    createdRecipes.add(recipe)
                } else {
                    recipeQueue.offer(recipeIdx)
                }
            }
        }
        return createdRecipes
    }
}
