class Solution2 {
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        var answer = mutableListOf<IntArray>()

        for (frame in build_frame) {
            val (x, y, stuff, operate) = frame
            if (operate == 0) {
                val tests = answer.filter { it[0] != x || it[1] != y || it[2] != stuff }.toMutableList()
                var isDelete = true
                for (test in tests) {
                    if (!possible(tests, test[0], test[1], test[2])) {
                        isDelete = false
                        break
                    }
                }
                if (isDelete) answer = tests
            } else {
                if (possible(answer, x, y, stuff)) answer.add(intArrayOf(x, y, stuff))
            }
        }
        val edges:Array<IntArray> = arrayOf()
        return answer.sortedWith(compareBy({ it[0] }, { it[1] }, { it[2] })).toTypedArray()
    }

    fun possible(answer: MutableList<IntArray>, x: Int, y: Int, stuff: Int): Boolean {
        if (stuff == 0) {
            if (y == 0)
                return true
            if (answer.any { it[2] == 0 && it[1] == y - 1 && it[0] == x })
                return true
            if (answer.any { it[2] == 1 && it[1] == y && (it[0] == x - 1 || it[0] == x) })
                return true
        } else {
            if (answer.any { it[2] == 0 && (it[1] == y - 1) && (it[0] == x || it[0] == x + 1) })
                return true
            if (answer.filter { it[2] == 1 && (it[1] == y) && (it[0] == x - 1 || it[0] == x + 1) }.size == 2)
                return true
        }
        return false
    }
}