package org.athenian

import java.io.File

fun main() {

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
    println("Average of even numbers <= 8 squared: $v2")

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

    val flatMapNums =
        IntRange(0, 6)
            .flatMap {
                if (it % 2 == 0)
                    listOf(it, it, it)
                else
                    emptyList()
            }
    println("Flatmap numbers: $flatMapNums")

    val mappedFlatMapNums =
        IntRange(1, 10)
            .flatMap { v ->
                // Avoid shadowing it by using v
                IntRange(1, v * 2).map { v }
            }
            .groupBy { it }
            .map { (k, v) -> k to v.size }
    println("Mapped flatmap numbers: $mappedFlatMapNums")

    val words =
        File("/usr/share/dict/words")
            .bufferedReader()
            .lineSequence()
            .filter { it.startsWith("pa") }
            .groupBy { it.length }
            .map { (k, v) -> k to v.size }
    println("Dict words: $words")

    val palindromes =
        File("/usr/share/dict/words")
            .bufferedReader()
            .lineSequence()
            .filter { it == it.reversed() }
            .toList()
    println("Palindromes: $palindromes")
}