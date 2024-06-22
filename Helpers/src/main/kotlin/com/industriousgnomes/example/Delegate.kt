package com.industriousgnomes.example

interface ICallbackReceiver {
    fun onBeforeAction()
    fun onAfterAction()
    fun action(function: () -> Unit) {
        onBeforeAction()
        function()
        onAfterAction()
    }
}

interface ILogger {
    fun getStubDateTime() = "05.11.2022-14:31:04"

    val format: String
        get() = "[${getStubDateTime()}]: "

    fun print(s: String)
}

class BasicLogger: ILogger {
    override fun print(s: String) = println(format + s)
}

class ConsoleNotifier(logger: ILogger) : ICallbackReceiver, ILogger by logger {
    val onBeforeStr = "OnBefore"
    val onAfterStr = "OnAfter"

    override fun onBeforeAction() = print(onBeforeStr)
    override fun onAfterAction() = print(onAfterStr)
}

class ExampleParser(notifier: ICallbackReceiver, logger: ILogger) : ICallbackReceiver by notifier, ILogger by logger {
    fun start() = action { parseFiles() }

    fun parseFiles() {
        println("parse files")
    }
}

fun main() {
    val logger = BasicLogger()
    ExampleParser(ConsoleNotifier(logger), logger).start()
}