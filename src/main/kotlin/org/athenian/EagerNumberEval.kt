package org.athenian

fun main() {
    val lst = listOf(1, 2, 3, 4, 5)
    val lstMapped =
        lst.map {
            println("Processing $it")
            it * it
        }
    println("Before sum")
    val sum = lstMapped.sum()
    println("Sum = $sum")
}
