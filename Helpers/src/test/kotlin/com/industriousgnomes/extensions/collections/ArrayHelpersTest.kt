package com.industriousgnomes.extensions.collections

import io.kotest.assertions.print.Print
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ArrayHelpersTest : FunSpec ({

    test ("2-Dimentional Array of char displayed in a table format") {
        val originalOut = System.out
        val outputStream = ByteArrayOutputStream()
        var captureOutput = ""

        try {
            System.setOut(PrintStream(outputStream))

            Array(101) { Array(120) { '~' } }.display()
            captureOutput = outputStream.toString().trim()
            assert(captureOutput.isNotBlank())

        } finally {
            System.setOut(originalOut)
            println(captureOutput)
        }
    }
})