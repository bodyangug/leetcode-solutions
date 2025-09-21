package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/design-movie-rental-system
class DesignMovieRentalSystem(n: Int, entries: Array<IntArray>) {

    private val priceMap = HashMap<Pair<Int, Int>, Int>()

    // movie -> available shops (unrented), ordered by (price asc, shop asc)
    private val available = HashMap<Int, TreeSet<Shop>>()

    // globally rented copies, ordered by (price asc, shop asc, movie asc)
    private val rented = TreeSet<Rental>()

    init {
        for (e in entries) {
            val shop = e[0]
            val movie = e[1]
            val price = e[2]
            priceMap[shop to movie] = price
            val set = available.getOrPut(movie) {
                TreeSet(compareBy<Shop>({ it.price }, { it.shop }))
            }
            set.add(Shop(shop, price))
        }
    }

    fun search(movie: Int): List<Int> {
        val set = available[movie] ?: return emptyList()
        val it = set.iterator()
        val res = ArrayList<Int>(5)
        var cnt = 0
        while (it.hasNext() && cnt < 5) {
            res.add(it.next().shop)
            cnt++
        }
        return res
    }

    fun rent(shop: Int, movie: Int) {
        val price = priceMap[shop to movie]!!
        available[movie]?.remove(Shop(shop, price))
        rented.add(Rental(price, shop, movie))
    }

    fun drop(shop: Int, movie: Int) {
        val price = priceMap[shop to movie]!!
        rented.remove(Rental(price, shop, movie))
        // add back to available
        val set = available.getOrPut(movie) {
            TreeSet(compareBy<Shop>({ it.price }, { it.shop }))
        }
        set.add(Shop(shop, price))
    }

    fun report(): List<List<Int>> {
        val res = ArrayList<List<Int>>(5)
        val it = rented.iterator()
        var cnt = 0
        while (it.hasNext() && cnt < 5) {
            val r = it.next()
            res.add(listOf(r.shop, r.movie))
            cnt++
        }
        return res
    }

    private data class Shop(val shop: Int, val price: Int)

    // Order fields as (price, shop, movie) to use natural ordering in TreeSet
    private data class Rental(val price: Int, val shop: Int, val movie: Int) : Comparable<Rental> {
        override fun compareTo(other: Rental): Int {
            if (price != other.price) return price - other.price
            if (shop != other.shop) return shop - other.shop
            return movie - other.movie
        }
    }
}
