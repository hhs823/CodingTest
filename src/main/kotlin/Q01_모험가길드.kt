import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    var N = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    var list = MutableList(N) { st.nextToken().toInt() }.sortedDescending()

    var answer = 0
    while (list.isNotEmpty()) {
        val team = list[0]
        if (team > N) {
            list = list.subList(1, list.size)
        } else {
            N -= team
            list = list.subList(team - 1, list.size)
            answer++
        }
    }

    println(answer)
}