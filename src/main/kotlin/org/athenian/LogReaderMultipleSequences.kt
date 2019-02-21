package org.athenian

import java.io.File

fun main() {
    val file = File("data/access.log")
    val linesInFile = getLines(file)
    val bytesColumn = getBytesColumn(linesInFile)
    val bytes = getBytes(bytesColumn)
    val total = bytes.sum()
    println("Total bytes: $total")
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