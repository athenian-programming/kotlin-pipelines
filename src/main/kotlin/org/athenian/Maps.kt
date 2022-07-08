package org.athenian

fun main() {
    fun <T> Collection<T>.andMap(block: (T) -> Boolean) =
        map(block).all { it }

    fun <T> Collection<T>.orMap(block: (T) -> Boolean) =
        map(block).any { it }

    println(listOf(1, 2, 3).andMap { it > 0 })
    println(listOf(1, 2, 3).andMap { it > 1 })

    println(listOf(1, 2, 3).orMap { it > 0 })
    println(listOf(1, 2, 3).orMap { it > 1 })
    println(listOf(1, 2, 3).orMap { it > 5 })
}