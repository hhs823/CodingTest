fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()

    val front = s.substring(0, s.length / 2).fold(0) { acc, c -> acc + c.toInt() - '0'.toInt() }
    val back = s.substring(s.length / 2).fold(0) { acc, c -> acc + c.toInt() - '0'.toInt() }

    if(front == back) println("LUCKY") else println("READY")
}