package org.athenian

fun oddNumbers(max: Int): Sequence<Int> =
    sequence {
        (0..max)
            .filter { it % 2 != 0 }
            .forEach { yield(it) }
    }

fun main() {
    val numbers =
        sequence<Int> {
            println("one")
            yield(1)

            println("two")
            yield(2)

            println("three")
            yield(3)

            println("Sequence finished...")
        }

    numbers.forEach { println("number = $it") }
    println("Done...")

    println("Odd numbers <= 10: ${oddNumbers(10).toList()}")

    println("Odd numbers <= 20: ${oddNumbers(20).toList()}")
}