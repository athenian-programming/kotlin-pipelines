package org.athenian

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

    for (n in numbers)
        println("number = $n")
    println("Done...")

    print("Odd numbers <= 10: ")
    for (i in oddNumbers(10))
        print("$i ")
    println()

    print("Odd numbers <= 20: ")
    for (i in oddNumbers(20))
        print("$i ")
    println()
}

fun oddNumbers(max: Int): Sequence<Int> {
    return sequence {
        for (i in 0..max) {
            if (i % 2 != 0)
                yield(i)
        }
    }
}

