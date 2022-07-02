package org.athenian

fun evenNumbers() =
    sequence {
        for (i in 0..Int.MAX_VALUE)
            if (i % 2 == 0)
                yield(i)
    }

fun main() {

    val everyOther =
        doReMi()
            .mapIndexed { i, note -> if (i % 2 == 0) note else "" }
            .filter { it.isNotEmpty() }
            .toList()

    println("Every other: ${everyOther.toList()}")

    println("Even numbers <= 10: ${evenNumbers().take(10).toList()}")
    println("Even numbers <= 10: (${evenNumbers().take(10).joinToString(", ")})")

    val reversedOdds = oddNumbers().take(11).toList().reversed().joinToString(", ")
    println("Odd numbers <= 11 reversed: $reversedOdds")

    val zipped =
        evenNumbers()
            .take(6)
            .map { it * it }
            .zip(evenNumbers().take(6).map { it * it * it })
            .joinToString(", ")
    println("Zipped squares and cubes: $zipped")

    println("Min even number <= 10: ${evenNumbers().take(10).min()}")
    println("Max even number <= 10: ${evenNumbers().take(10).max()}")
    println("Count even numbers <= 40: ${evenNumbers().take(40).count()}")
    println("Average of even numbers <= 30: ${evenNumbers().take(30).average()}")

    println("First even number <= 20: ${evenNumbers().take(20).first()}")
    println("Last even number <= 20: ${evenNumbers().take(20).last()}")

    // Boolean operations
    println("Any even numbers <= 10 <= 6: ${evenNumbers().take(10).any { it <= 6 }}")
    println("All even numbers <= 10 <= 6: ${evenNumbers().take(10).all { it <= 6 }}")
}