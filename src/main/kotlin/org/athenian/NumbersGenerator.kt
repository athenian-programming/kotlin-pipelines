package org.athenian

fun evenNumbers(max: Int): Sequence<Int> {
    return sequence {
        for (i in 1..max) {
            if (i % 2 == 0)
                yield(i)
        }
    }
}

fun oddNumbers(max: Int) =
    sequence {
        IntRange(1, max)
            .forEach {
                if (it % 2 != 0)
                    yield(it)
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

    println("Even numbers <= 10: (${evenNumbers(10).joinToString(", ")})")

    println("Even numbers <= 10: ${evenNumbers(10).toList()}")
    println("Odd numbers <= 10: ${oddNumbers(10).toList()}")


    println("Min even number <= 10: ${evenNumbers(10).min()}")
    println("Max even number <= 10: ${evenNumbers(10).max()}")
    println("Count even number <= 10: ${evenNumbers(10).count()}")
    println("Average of even numbers <= 10: ${evenNumbers(10).average()}")
    println("First even number <= 10: ${evenNumbers(10).first()}")

    // Boolean operations
    println("Any even numbers <= 10 <= 6: ${evenNumbers(10).any { it <= 6 }}")
    println("All even numbers <= 10 <= 6: ${evenNumbers(10).all { it <= 6 }}")

    println("All numbers <= 10 ${evenNumbers(10).plus(oddNumbers(10)).sorted().toList()}")
}