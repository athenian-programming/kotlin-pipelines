package org.athenian

fun <T> Sequence<T>.everyNth(inc: Int) = EveryNthSequence(inc, this)

class EveryNthSequence<T>(private val inc: Int, private val underlyingSequence: Sequence<T>) : Sequence<T> {
    override fun iterator() =
        object : Iterator<T> {
            val iterator = underlyingSequence.iterator()

            override fun hasNext() = iterator.hasNext()

            override fun next(): T {
                val item = iterator.next()
                (1..inc - 1).forEach {
                    if (iterator.hasNext())
                        iterator.next()
                }
                return item
            }
        }
}

fun main() {
    (0..50)
        .asSequence()
        .everyNth(5)
        .forEach { println("Value: $it") }

}