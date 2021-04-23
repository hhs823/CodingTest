fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()
    println(((s.filter { it.isLetter() }.toMutableList().sorted())
            + (s.filter { it.isDigit() }.toMutableList()
        .fold(0) { acc, c -> acc + c.toInt() - '0'.toInt() }))
        .joinToString(""))
}