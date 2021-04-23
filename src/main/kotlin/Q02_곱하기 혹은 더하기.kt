import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine().toCharArray().map { it.toInt() - '0'.toInt() }

    val answer = (1 until s.size).fold(s[0]) { acc, i -> max(acc + s[i], acc * s[i]) }
    println(answer)
}