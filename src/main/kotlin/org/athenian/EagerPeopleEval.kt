package org.athenian

data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Chris Martin", 31),
    Person("Will Champion", 32),
    Person("Johny Buckland", 33),
    Person("Guy Berryman", 34),
    Person("Mhris Cartin", 30)
)

fun main() {
    println(
        people
            .filter { it.age > 30 }
            .map {
                it.name
                    .split(" ")
                    .map { names -> names[0] }
                    .joinToString("")
            }
            .map { it.toUpperCase() })
}