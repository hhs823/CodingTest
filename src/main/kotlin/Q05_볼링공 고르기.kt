fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val balls = br.readLine().split(" ").map { it.toInt() }

    val count =
        Array(m + 1) { i -> balls.count { it == i } to balls.count { it > i } }.fold(0) { acc, pair -> acc + pair.first * pair.second }
    println(count)
}