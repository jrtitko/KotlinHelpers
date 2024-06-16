package com.industriousgnomes.extensions.collections

/*
    Display the elements in the array as a table labeled with column and row positions.
 */
fun Array<Array<Char>>.display(rowLabelWidth: Int = this.size.toString().length, dataWidth: Int = this.maxOf { it.size.toString().length }) {
    val transform: (Any) -> CharSequence = { "$it".padStart(dataWidth) }
    println((0 until this[0].size).joinToString(" ", prefix = " ".padStart(rowLabelWidth + 1), transform = transform))
    this.forEachIndexed { r, row ->
        println(row.joinToString(" ", prefix = "$r ".padStart(rowLabelWidth + 1), transform = transform))
    }
}

// Examples to call the helper extension functions.
class ArrayHelpers {
    companion object {
        fun demo2dArrayDisplay() {
            Array(101) { Array(120) { '~' } }.display()
        }
    }
}