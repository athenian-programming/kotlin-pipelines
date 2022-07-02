package org.athenian

import java.io.File

fun main() {
    val v1 =
        evenNumbers()
            .take(10)
            .filter { it <= 8 }
            .average()
    println("Average of even numbers <= 8: $v1")

    val v2 =
        evenNumbers()
            .take(10)
            .filter { it <= 8 }
            .map { it * it }
            .average()
    println("Average of even numbers <= 8 squared: $v2")

    val allNums =
        evenNumbers()
            .take(5)
            .plus(oddNumbers().take(5))
            .sorted()
            .toList()
    println("All numbers <= 10: $allNums")

    val flatMapNums =
        (0..6)
            .flatMap {
                if (it % 2 == 0)
                    List(it) { v -> it }
                else
                    emptyList()
            }
    println("Flatmap numbers: $flatMapNums")

    val mappedFlatMapNums =
        (1..10)
            .flatMap { (1..(it * 2)).map { i -> it } }
            //.also { println(it) }
            .groupBy { it }
            //.also { println(it) }
            .map { (i, v) -> i to v.size }
    println("Mapped flatmap numbers: $mappedFlatMapNums")

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