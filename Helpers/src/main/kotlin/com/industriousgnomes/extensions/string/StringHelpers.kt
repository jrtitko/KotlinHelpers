package com.industriousgnomes.extensions.string

/*
    Display the string as a prompt and wait for a response.
 */
fun String.reply() = println(this).run { readln() }