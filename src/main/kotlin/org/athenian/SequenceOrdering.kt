package org.athenian


fun main() {

    val nosequnce =
        (0..10)
            .onEach { println("Evaluating #1 $it") }
            .onEach { println("Evaluating #2 $it") }
            .take(5)
            .toList()
    println(nosequnce)

    val sequnce =
        (0..10)
            .asSequence()
            .onEach { println("Evaluating #1 $it") }
            .onEach { println("Evaluating #2 $it") }
            .take(5)
            .toList()
    println(sequnce)

}

