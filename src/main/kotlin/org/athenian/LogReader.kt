package org.athenian

import java.io.File

fun main() {

    fun getLines(file: File): Sequence<String> {
        // Non expression body
        return sequence {
            val data = file.bufferedReader().lineSequence()
            for (line in data)
                yield(line)
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
            data.filter { it != "-" }
                .forEach { yield(it.toInt()) }
        }

    fun withMultipleSequences(file: File): Int {
        val linesInFile = getLines(file)
        val bytesColumn = getBytesColumn(linesInFile)
        val bytes = getBytes(bytesColumn)
        return bytes.sum()
    }

    fun withSingleSequence1(file: File): Int {
        val lines =
            sequence {
                val data = file.bufferedReader().lineSequence()
                for (line in data) {
                    yield(line)
                }
            }
        return lines
            .map { it.split(" ") }
            .filter { it.size == 19 }
            .map { it[9] }
            .filter { it != "-" }
            .map { it.toInt() }
            .sum()
    }

    fun withSingleSequence2(file: File): Int =
        file.bufferedReader()
            .lineSequence()
            .map { it.split(" ") }
            .filter { it.size == 19 }
            .map { it[9] }
            .filter { it != "-" }
            .map { it.toInt() }
            .sum()

    val file = File("data/access.log")
    println("Total bytes with multiple sequences: ${withMultipleSequences(file)}")
    println("Total bytes with single sequence1: ${withSingleSequence1(file)}")
    println("Total bytes with single sequence2: ${withSingleSequence2(file)}")
}
