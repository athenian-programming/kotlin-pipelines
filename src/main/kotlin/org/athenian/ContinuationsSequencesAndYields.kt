package org.athenian

fun oddNumbers(): Sequence<Int> =
    sequence {
        (0..Int.MAX_VALUE)
            .asSequence()
            .filter { it % 2 != 0 }
            .forEach { yield(it) }
    }

fun main() {
    val numbers =
        sequence {
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

    println("Odd numbers <= 10: ${oddNumbers().take(10).toList()}")

    println("Odd numbers <= 20: ${oddNumbers().take(20).toList()}")
}