package org.athenian

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

fun <T> Iterable<T>.everyNth(inc: Int): List<T> = everyNth(ArrayList<T>(), inc)

fun <T, C : MutableCollection<in T>> Iterable<T>.everyNth(destination: C, inc: Int): C {
    var counter = 0
    for (element in this) {
        if (counter % inc == 0)
            destination.add(element)
        counter++
    }
    return destination
}


fun main() {
    (0..50)
        .asSequence()
        .everyNth(5)
        .forEach { println("Value: $it") }

    (0..50)
        .everyNth(5)
        .forEach { println("Value: $it") }
}