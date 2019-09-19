package org.athenian

fun main() {

    data class Person(val name: String, val age: Int)

    val people = listOf(
        Person("Chris martin", 31),
        Person("Will champion", 32),
        Person("Johny buckland", 33),
        Person("Guy berryman", 34),
        Person("Mhris cartin", 30)
    )

    println(
        "Eager eval: " +
                people
                    .filter { it.age > 30 }
                    .onEach { println("First map evaluating $it") }
                    .map {
                        it.name
                            .split(" ")
                            .map { name -> name[0] }
                            .joinToString("")
                    }
                    .onEach { println("Second map evaluating $it") }
                    .map { it.toUpperCase() })

    println("Lazy eval: " +
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