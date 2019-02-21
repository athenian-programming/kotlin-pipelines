package org.athenian

fun evenNumbers(max: Int): Sequence<Int> {
    return sequence {
        for (i in 1..max) {
            if (i % 2 == 0)
                yield(i)
        }
    }
}

fun main() {
    print("Even numbers <= 10: ")
    for (i in evenNumbers(10))
        print("$i ")
    println()

    print("Even numbers <= 10: ")
    evenNumbers(10).forEach { print("$it ") }
    println()

    println("Even numbers <= 10: ${IntRange(0, 10).filter { it % 2 == 0 }}")

    println("Even numbers <= 10: ${evenNumbers(10).toList()}")
    println("Even numbers <= 10: (${evenNumbers(10).joinToString(", ")})")

    println("Min even number <= 10: ${evenNumbers(10).min()}")
    println("Max even number <= 10: ${evenNumbers(10).max()}")
    println("Count even number <= 10: ${evenNumbers(10).count()}")
    println("Average of even numbers <= 10: ${evenNumbers(10).average()}")
    println("First even number <= 10: ${evenNumbers(10).first()}")

    // Chained
    val v1 =
        evenNumbers(10)
            .filter { it <= 8 }
            .average()
    println("Average of even numbers <= 8: $v1")

    val v2 =
        evenNumbers(10)
            .filter { it <= 8 }
            .map { it * it }
            .average()
    println("Average of even numbers <= 8 squared : $v2")

    val oddNumbers =
        sequence {
            for (i in 0..10) {
                if (i % 2 != 0)
                    yield(i)
            }
        }

    val allNums =
        evenNumbers(10)
            .plus(oddNumbers)
            .sorted()
            .toList()

    println("All numbers <= 10 $allNums")

    // Boolean operations
    println("Any even numbers <= 10 <= 6: ${evenNumbers(10).any { it <= 6 }}")
    println("All even numbers <= 10 <= 6: ${evenNumbers(10).all { it <= 6 }}")
}