package org.athenian

fun <T> Sequence<T>.everyNth(inc: Int) =
    sequence {
        this@everyNth.withIndex().forEach { (index, element) ->
            if (index % inc == 0)
                yield(element)
        }
    }


fun <T> Iterable<T>.everyNth(inc: Int) =
    buildList {
        for ((index, element) in this@everyNth.withIndex()) {
            if (index % inc == 0)
                add(element)
        }
    }

fun main() {
    (0..50)
        .asSequence()
        .everyNth(5)
        .also { println("Sequence values: ${it.toList()}") }

    (0..50)
        .everyNth(5)
        .also { println("Non-sequence values: $it") }
}