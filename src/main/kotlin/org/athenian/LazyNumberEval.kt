package org.athenian

fun main() {
    val seq = sequenceOf(1, 2, 3, 4, 5)
    val seqMapped =
        seq.map {
            println("Processing $it")
            it * it
        }
    println("Before sum")
    val sum = seqMapped.sum()
    println("Sum = $sum")
}