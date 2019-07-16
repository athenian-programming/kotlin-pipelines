package org.athenian

fun doReMi(): Sequence<String> {
    val notes = listOf("Do", "Re", "Mi", "Fa", "Sol", "La", "Ti", "Do")
    return sequence {
        for (note in notes)
            yield(note)
    }
}

fun factorOfFive(max: Int): Sequence<Int> {
    return sequence {
        for (i in 0 until max step 5)
            yield(i)
    }
}

fun main() {
    for (note in doReMi())
        println("Singing $note")

    for (f in factorOfFive(25))
        println("Val $f")
}
