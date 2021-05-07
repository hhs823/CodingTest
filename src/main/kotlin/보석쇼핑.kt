import java.util.*

class Solution {
    // 0: left, 1: up, 2: right, 3:down
    val LEFT = 0
    val UP = 1
    val RIGHT = 2
    val DOWN = 3

    val dx = listOf(0, -1, 0, 1)
    val dy = listOf(-1, 0, 1, 0)

    fun solution(board: Array<IntArray>): Int {
        var answer = 0

        val que = ArrayDeque<Pos>()
        val cost = Array(board.size) { IntArray(board.size) { 98765432 } }

        if (board[1][0] == 0) {
            que.add(Pos(1, 0, DOWN))
            cost[1][0] = 100
        }
        if (board[0][1] == 0) {
            que.add(Pos(0, 1, RIGHT))
            cost[0][1] = 100
        }

        while (que.isNotEmpty()) {
            val now = que.poll()
            for (i in 0..3) {
                val nx = now.x + dx[i]
                val ny = now.y + dy[i]
                if (nx !in board.indices || ny !in board.indices) continue
                val pay = when (now.dir) {
                    LEFT, RIGHT -> if (i == LEFT || i == RIGHT) 100 else 600
                    else -> if (i == UP || i == DOWN) 100 else 600
                }
                if (board[nx][ny] == 0 && cost[nx][ny] > cost[now.x][now.y] + pay) {
                    cost[nx][ny] = cost[now.x][now.y] + pay
                    que.add(Pos(nx, ny, i))
                }
            }
        }

        cost.forEach {
            it.forEach {print("%5d".format(it))}
            println()
        }

        return cost[board.size - 1][board.size - 1]
    }

    data class Pos(val x: Int, val y: Int, val dir: Int)
}
