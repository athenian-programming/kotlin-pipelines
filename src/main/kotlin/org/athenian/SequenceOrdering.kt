package org.athenian


fun main() {
    (0..10)
        .onEach { println("Evaluating #1 $it") }
        .onEach { println("Evaluating #2 $it") }
        .take(5)
        .toList()
        .also { println("No sequence: $it") }

    (0..10)
        .asSequence()
        .onEach { println("Evaluating #1 $it") }
        .onEach { println("Evaluating #2 $it") }
        .take(5)
        .toList()
        .also { println("With sequence: $it") }
}