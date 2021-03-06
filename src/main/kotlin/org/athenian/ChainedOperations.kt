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
            (0..10)
                .filter { it % 2 != 0 }
                .forEach { yield(it) }
        }

    val allNums =
        evenNumbers(10)
            .plus(oddNumbers)
            .sorted()
            .toList()
    println("All numbers <= 10 $allNums")

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
            .flatMap {
                (1..(it * 2))
                    .map { v -> it } // Avoid shadowing "it" by using v
            }
            //.onEach { println(it) }
            .groupBy { it }
            //.onEach { println(it) }
            .map { (k, v) -> k to v.size }
    println("Mapped flatmap numbers: $mappedFlatMapNums")

    val words =
        File("data/words")
            .bufferedReader()
            .lineSequence()
            .filter { it.startsWith("pa") }
            .groupBy { it.length }
            .map { (k, v) -> k to v.size }
    println("Dict words: $words")

    val palindromes =
        File("data/words")
            .bufferedReader()
            .lineSequence()
            .filter { it.length > 1 }
            .filter { it == it.reversed() }
            .toList()
    println("${palindromes.size} palindromes: $palindromes")

    val longest =
        palindromes
            .groupBy { it.length }
            .maxBy { it.key }
    println("Longest palindromes with length of ${longest!!.key}: ${longest.value}")

    val greatest =
        palindromes
            .groupBy { it.length }
            .maxBy { it.value.size }
    println("Greatest # (${greatest!!.value.size}) of palindromes with length of ${greatest.key}: ${greatest.value}")
}