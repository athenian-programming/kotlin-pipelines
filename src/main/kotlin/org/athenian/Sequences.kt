package org.athenian

fun doReMi(): Sequence<String> =
    sequence {
        listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do").forEach { yield(it) }
    }

fun factorOfFive(max: Int): Sequence<Int> =
    sequence {
        for (i in 0 until max step 5)
            yield(i)
    }

fun main() {
    
    doReMi().forEach { println("Singing $it") }

    factorOfFive(25).forEach { println("Val $it") }
}
