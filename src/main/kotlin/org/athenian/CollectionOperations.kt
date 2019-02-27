package org.athenian

fun evenNumbers(max: Int): Sequence<Int> {
    return sequence {
        for (i in 0..max) {
            if (i % 2 == 0)
                yield(i)
        }
    }
}

fun main() {
    print("Even numbers <= 10: ")
    evenNumbers(10).forEach { print("$it ") }
    println()

    println("Even numbers <= 10: ${evenNumbers(10).toList()}")
    println("Even numbers <= 10: (${evenNumbers(10).joinToString(", ")})")

    println("Min even number <= 10: ${evenNumbers(10).min()}")
    println("Max even number <= 10: ${evenNumbers(10).max()}")
    println("Count even number <= 10: ${evenNumbers(10).count()}")
    println("Average of even numbers <= 10: ${evenNumbers(10).average()}")
    println("First even number <= 10: ${evenNumbers(10).first()}")

    println("Even numbers <= 10: ${IntRange(0, 10).filter { it % 2 == 0 }}")

    // Boolean operations
    println("Any even numbers <= 10 <= 6: ${evenNumbers(10).any { it <= 6 }}")
    println("All even numbers <= 10 <= 6: ${evenNumbers(10).all { it <= 6 }}")
}