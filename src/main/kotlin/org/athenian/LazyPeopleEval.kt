package org.athenian

fun main() {
    println(
        people
            .asSequence()
            .filter { it.age > 30 }
            .onEach { println("First map evaluating $it") }
            .map {
                it.name
                    .split(" ")
                    .map { name -> name[0] }
                    .joinToString("")
            }
            .onEach { println("Second map evaluating $it") }
            .map { it.toUpperCase() }
            .toList()
    )
}