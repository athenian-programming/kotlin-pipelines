package org.athenian

fun main() {
    val listVals =
        listOf(1, 2, 3, 4, 5)
            .onEach { println("Processing list value: $it") }
            .map { it * it }

    println("Before list sum")
    println("List sum: ${listVals.sum()}")


    val seqVals =
        sequenceOf(1, 2, 3, 4, 5)
            .onEach { println("Processing sequence value: $it") }
            .map { it * it }

    println("Before sequence sum")
    println("Sequence sum: ${seqVals.sum()}")
}