package org.athenian

fun main() {
    println(
        people
            .asSequence()
            .filter { it.age > 30 }
            .map {
                println("First map evaluating $it")
                it.name
                    .split(" ")
                    .map { name -> name[0] }
                    .joinToString("")
            }
            .map {
                println("Second map evaluating $it")
                it.toUpperCase()
            }
            .toList()
    )
}