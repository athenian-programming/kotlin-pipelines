package org.athenian

fun <T> Sequence<T>.everyOther() = EveryOtherSequence(this)

class EveryOtherSequence<T>(private val underlyingSequence: Sequence<T>) : Sequence<T> {
    override fun iterator() =
        object : Iterator<T> {
            val iterator = underlyingSequence.iterator()

            override fun hasNext() = iterator.hasNext()

            override fun next(): T {
                val item = iterator.next()
                if (iterator.hasNext())
                    iterator.next()
                return item
            }
        }
}

fun main() {
    (0..10)
        .asSequence()
        .everyOther()
        .forEach { println("Value: $it") }
}