package org.athenian

fun main() {
    println(
        people
            .asSequence()
            .filter { it.age > 30 }
            .map {
                it.name
                    .split(" ")
                    .map { names -> names[0] }
                    .joinToString("")
            }
            .map { it.toUpperCase() }
            .toList()
    )
}