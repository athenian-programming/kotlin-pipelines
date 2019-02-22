package org.athenian

fun main() {
    val lst = listOf(1, 2, 3, 4, 5)

    val lstMapped =
        lst.onEach { println("Processing list value: $it") }
            .map { it * it }
    println("Before list sum")
    val lstSum = lstMapped.sum()
    println("List sum:  $lstSum")

    println()

    val seq = sequenceOf(1, 2, 3, 4, 5)
    //val seq = lst.asSequence()

    val seqMapped =
        seq.onEach { println("Processing sequence value: $it") }
            .map { it * it }
    println("Before sequence sum")
    val seqSum = seqMapped.sum()
    println("Sequence sum: $seqSum")
}
