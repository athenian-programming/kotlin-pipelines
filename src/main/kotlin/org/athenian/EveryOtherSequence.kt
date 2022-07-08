package org.athenian

fun <T> Sequence<T>.everyOther() =
    sequence {
        var skip = false
        this@everyOther.forEach { element ->
            if (!skip)
                yield(element)
            skip = !skip
        }
    }

fun <T> Iterable<T>.everyOther() =
    buildList {
        var skip = false
        for (element in this@everyOther) {
            if (!skip)
                this += element
            skip = !skip
        }
    }

fun main() {
    (0..10)
        .asSequence()
        .everyOther()
        .also { println("Sequence values: ${it.toList()}") }

    (0..10)
        .everyOther()
        .also { println("Non-sequence values: $it") }
}