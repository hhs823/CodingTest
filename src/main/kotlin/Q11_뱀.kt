import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n) { Array(n) { 0 } }

    val k = br.readLine().toInt()
    repeat(k) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        board[i - 1][j - 1] = 1
    }

    val l = br.readLine().toInt()
    val direction = ArrayDeque<Pair<Int, Char>>()
    repeat(l) {
        val st = StringTokenizer(br.readLine())
        direction.add(st.nextToken().toInt() to st.nextToken()[0])
    }

    // Right = 0 Up = 3 Left = 2 Down = 1
    var dir = 0
    var time = 0
    board[0][0] = 2
    var curr = 0 to 0
    val snake = ArrayDeque<Pair<Int, Int>>()
    snake.add(curr)

    while (true) {
        // move
        when (dir) {
            0 -> curr = curr.first to curr.second + 1
            1 -> curr = curr.first + 1 to curr.second
            2 -> curr = curr.first to curr.second - 1
            3 -> curr = curr.first - 1 to curr.second
        }

        // 이동 후 벽에 부딪힌 경우
        if (curr.first !in board.indices || curr.second !in board.indices) {
            println("$time")
            return
        }
        // 이동 후 자기 자신을 만난 경우
        if (board[curr.first][curr.second] == 2) {
            println("$time 자기자신")
            return
        }

        snake.add(curr)
        if (board[curr.first][curr.second] == 0) {
            val tail = snake.removeFirst()
            board[tail.first][tail.second] = 0
        }

        board[curr.first][curr.second] = 2

        if(direction.first().first == time) {
            dir = rotate(dir, direction.removeFirst().second)
        }
        time++
    }
}

fun rotate(now: Int, dir: Char): Int =
    when (dir) {
        'L' -> if (now - 1 < 0) 3 else now - 1
        else -> if (now + 1 > 3) 0 else now + 1
    }