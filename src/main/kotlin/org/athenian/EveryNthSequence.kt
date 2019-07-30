package org.athenian

import java.util.concurrent.atomic.AtomicInteger

fun <T> Sequence<T>.everyNth(inc: Int) = EveryNthSequence(inc, this)

class EveryNthSequence<T>(private val inc: Int, private val underlyingSequence: Sequence<T>) : Sequence<T> {
    override fun iterator() =
        object : Iterator<T> {
            val iterator = underlyingSequence.iterator()

            override fun hasNext() = iterator.hasNext()

            override fun next(): T {
                val item = iterator.next()
                repeat(inc - 1) {
                    if (!iterator.hasNext())
                        return@repeat
                    iterator.next()
                }
                return item
            }
        }
}

public fun <T> Iterable<T>.everyNth(inc: Int): List<T> = everyNth(ArrayList<T>(), inc)

public fun <T, C : MutableCollection<in T>> Iterable<T>.everyNth(destination: C, inc: Int): C {
    val counter = AtomicInteger(0)
    for (element in this)
        if (counter.getAndIncrement() % inc == 0)
            destination.add(element)
    return destination
}


fun main() {
    (0..50)
        .asSequence()
        .everyNth(5)
        .forEach { println("Value: $it") }

    (0..50)
        .everyNth(50)
        .forEach { println("Value: $it") }
}