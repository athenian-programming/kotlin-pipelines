package org.athenian

import java.util.concurrent.atomic.AtomicInteger

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

public fun <T> Iterable<T>.everyOther(): List<T> = everyOther(ArrayList<T>())

public fun <T, C : MutableCollection<in T>> Iterable<T>.everyOther(destination: C): C {
    val counter = AtomicInteger(0)
    for (element in this)
        if (counter.getAndIncrement() % 2 == 0)
            destination.add(element)
    return destination
}

fun main() {
    (0..10)
        .asSequence()
        .everyOther()
        .forEach { println("Value: $it") }

    (0..10)
        .everyOther()
        .forEach { println("Value: $it") }
}