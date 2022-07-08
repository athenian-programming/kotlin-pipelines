package org.athenian

import kotlin.system.measureTimeMillis

fun main() {
    class DataFetcher {
        fun fetch(valueToFind: Int): Int {
            Thread.sleep(100)
            return if (valueToFind == 10) valueToFind else -1
        }
    }

    val dataFetcher = DataFetcher()

    val eagerTime =
        measureTimeMillis {
            print(
                (1..50)
                    .onEach { println("Evaluating $it") }
                    .map { dataFetcher.fetch(it) }
                    .any { it == 10 })
        }
    println(" took ${eagerTime}ms with eager evaluation.")

    measureTimeMillis {
        print(
            (1..50)
                .asSequence()
                .onEach { println("Evaluating $it") }
                .map { dataFetcher.fetch(it) }
                .any { it == 10 })
    }
        .also { println(" took $it ms with lazy evaluation.") }
}