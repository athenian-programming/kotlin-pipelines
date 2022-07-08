package org.athenian

import java.io.File

fun main() {
    evenNumbers()
        .take(10)
        .filter { it <= 8 }
        .average()
        .also { println("Average of even numbers <= 8: $it") }

    evenNumbers()
        .take(10)
        .filter { it <= 8 }
        .map { it * it }
        .average()
        .also { println("Average of even numbers <= 8 squared: $it") }

    evenNumbers()
        .take(5)
        .plus(oddNumbers().take(5))
        .sorted()
        .toList()
        .also { println("All numbers <= 10: $it") }

    (0..6)
        .flatMap {
            if (it % 2 == 0)
                List(it) { v -> it }
            else
                emptyList()
        }
        .also { println("Flatmap numbers: $it") }

    (1..10)
        .flatMap { (1..(it * 2)).map { i -> it } }
        //.also { println(it) }
        .groupBy { it }
        //.also { println(it) }
        .map { (i, v) -> i to v.size }
        .also { println("Mapped flatmap numbers: $it") }

    File("data/words")
        .bufferedReader()
        .lineSequence()
        .filter { it.startsWith("pa") }
        .groupBy { it.length }
        .map { (k, v) -> k to v.size }
        .also { println("Dict words: $it") }

    val palindromes =
        File("data/words")
            .bufferedReader()
            .lineSequence()
            .filter { it.length > 1 }
            .filter { it == it.reversed() }
            .toList()
    println("${palindromes.size} palindromes: $palindromes")

    palindromes
        .groupBy { it.length }
        .maxBy { it.key }
        .also { println("Longest palindromes with length of ${it.key}: ${it.value}") }

    palindromes
        .groupBy { it.length }
        .maxBy { it.value.size }
        .also { println("Greatest # (${it.value.size}) of palindromes with length of ${it.key}: ${it.value}") }
}