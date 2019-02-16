package org.athenian

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Chris martin", 31),
    Person("Will champion", 32),
    Person("Johny buckland", 33),
    Person("Guy berryman", 34),
    Person("Mhris cartin", 30)
)

fun main() {
    println(
        people
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
            })
}