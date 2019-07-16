package org.athenian

fun evenNumbers(max: Int): Sequence<Int> {
    return sequence {
        for (i in 0..max)
            if (i % 2 == 0)
                yield(i)
    }
}

fun main() {

    val everyOther =
        doReMi()
            .mapIndexed { i, note -> if (i % 2 == 0) note else "" }
            .filter { it.length > 0 }
            .toList()

    print("Even numbers <= 10: ")
    evenNumbers(10).forEach { print("$it ") }
    println()

    println("Even numbers <= 10: ${evenNumbers(10).toList()}")
    println("Even numbers <= 10: (${evenNumbers(10).joinToString(", ")})")

    val reversedOdds = oddNumbers(11).toList().reversed().joinToString(", ")
    println("Odd numbers <= 11 reversed: $reversedOdds")

    val zipped = evenNumbers(6).map { it * it }.zip(evenNumbers(6).map { it * it * it }).joinToString(", ")
    println("Zipped squares and cubes: $zipped")

    println("Min even number <= 10: ${evenNumbers(10).min()}")
    println("Max even number <= 10: ${evenNumbers(10).max()}")
    println("Count even numbers <= 40: ${evenNumbers(40).count()}")
    println("Average of even numbers <= 30: ${evenNumbers(30).average()}")

    println("First even number <= 20: ${evenNumbers(20).first()}")
    println("Last even number <= 20: ${evenNumbers(20).last()}")

    // Boolean operations
    println("Any even numbers <= 10 <= 6: ${evenNumbers(10).any { it <= 6 }}")
    println("All even numbers <= 10 <= 6: ${evenNumbers(10).all { it <= 6 }}")
}