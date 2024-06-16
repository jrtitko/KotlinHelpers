package com.industriousgnomes.extensions.string

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

private const val PROMPT = "What's your name?"
private const val REPLY = "Jerry"

class StringHelpersTest : FunSpec({

    test("reply to a prompt") {
        val originalIn = System.`in`
        val inputStream = ByteArrayInputStream(REPLY.toByteArray())

        val originalOut = System.out
        val outputStream = ByteArrayOutputStream()
        val captureOutput: String

        try {
            System.setIn(inputStream)
            System.setOut(PrintStream(outputStream))

            val response = PROMPT.reply()
            captureOutput = outputStream.toString().trim()
            captureOutput shouldBe PROMPT

            response shouldBe REPLY
        } finally {
            System.setIn(originalIn)
            System.setOut(originalOut)
        }
    }
})
