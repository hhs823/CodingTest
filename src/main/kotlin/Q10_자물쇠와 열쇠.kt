fun main() {
    class Solution {
        fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
            var boardSize = lock.size + (key.size - 1) * 2
            var rotated = key
            for (rot in 1..4) {
                rotated = rotate(rotated)
                // key start
                for (si in 0 until lock.size + key.size - 1) {
                    for (sj in 0 until lock.size + key.size - 1) {
                        val board = Array(boardSize) { IntArray(boardSize) { 0 } }
                        // lock
                        for (i in lock.indices) {
                            for (j in lock.indices) {
                                board[key.size - 1 + i][key.size - 1 + j] = lock[i][j]
                            }
                        }

                        // key
                        for (i in rotated.indices) {
                            for (j in rotated.indices) {
                                if (rotated[i][j] == 1) {
                                    board[si + i][sj + j] = 1
                                }
                            }
                        }

                        // confirm
                        var flag = true
                        loop@ for (i in lock.indices) {
                            for (j in lock.indices) {
                                if (board[key.size - 1 + i][key.size - 1 + j] != 1) {
                                    flag = false
                                    break@loop
                                }
                            }
                        }
                        if (flag) return true
                    }
                }
            }

            return false
        }

        fun rotate(arr: Array<IntArray>): Array<IntArray> =
            Array(arr.size) { i -> IntArray(arr.size) { j -> arr[arr.size - 1 - j][i] } }
    }
}