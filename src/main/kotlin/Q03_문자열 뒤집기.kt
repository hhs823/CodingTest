fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()

    var answer = 0
    var prev = s[0]
    s.forEach {
        if (it != prev) {
            answer++
            prev = it
        }
    }

    println(answer / 2)
}