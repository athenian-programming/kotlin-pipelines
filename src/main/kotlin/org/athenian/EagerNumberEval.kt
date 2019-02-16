package org.athenian

fun main() {
    val lst = listOf(1, 2, 3, 4, 5)
    val lstMapped =
        lst.onEach { println("Processing $it") }
            .map { it * it }
    println("Before sum")
    val sum = lstMapped.sum()
    println("Sum = $sum")
}
