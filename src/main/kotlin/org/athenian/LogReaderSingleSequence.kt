package org.athenian

import java.io.File

fun main() {
    val file = File("data/access.log")
    val lines =
        sequence {
            val data = file.bufferedReader().lineSequence()
            for (line in data) {
                yield(line)
            }
        }
    val bytes =
        lines
            .map { it.split(" ") }
            .filter { it.size == 19 }
            .map { it[9] }
            .filter { it != "-" }
            .map { it.toInt() }
    val total = bytes.sum()
    println("Total bytes: $total")
}

