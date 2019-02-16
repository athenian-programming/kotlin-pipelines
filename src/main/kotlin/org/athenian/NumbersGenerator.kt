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

    println("Even numbers <= 10: ${evenNumbers(10).toList()}")

    println("Odd numbers <= 10: ${oddNumbers(10).toList()}")
}