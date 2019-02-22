package org.athenian

import java.io.File

fun main() {
    val file = File("data/access.log")
    println("Total bytes with multiple sequences: ${withMultipleSequences(file)}")
    println("Total bytes with single sequence: ${withSingleSequence(file)}")
}

fun withMultipleSequences(file: File): Int {
    val linesInFile = getLines(file)
    val bytesColumn = getBytesColumn(linesInFile)
    val bytes = getBytes(bytesColumn)
    return bytes.sum()
}

fun getLines(file: File): Sequence<String> {
    // Non expression body
    return sequence {
        val data = file.bufferedReader().lineSequence()
        for (line in data) {
            yield(line)
        }
    }
}

fun getBytesColumn(data: Sequence<String>) =
    sequence {
        for (line in data) {
            val cols = line.split(" ")
            if (cols.size != 19)
                continue
            val bytes = cols[9]
            yield(bytes)
        }
    }

fun getBytes(data: Sequence<String>) =
    sequence {
        for (item in data) {
            if (item != "-") {
                yield(item.toInt())
            }
        }
    }

fun withSingleSequence(file: File): Int {
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
    return bytes.sum()
}