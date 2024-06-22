package com.industriousgnomes.random

fun randomString(size: Int = 10): String {
    return Array(size) { listOf('a'..'z', 'A'..'Z').flatten().random() }.joinToString("")
}