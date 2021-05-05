import kotlin.math.*

fun main() {
    class Solution {
        val hm = HashMap<String, Boolean>()
        fun solution(gems: Array<String>): IntArray {
            var answer = intArrayOf(1, gems.size)

            if(gems.toHashSet().size == 1) return intArrayOf(1, 1)

            for (size in gems.toHashSet().size - 1 until gems.size) {
                for (i in 1..gems.size - size) {
                    if (confirm(gems, i, i + size)) {
                        if(answer[1] - answer[0] > size) {
                            answer[0] = i
                            answer[1] = i + size
                        }
                    }
                }
            }

            return answer
        }

        fun confirm(gems: Array<String>, start: Int, end: Int): Boolean {
            if (start > end) {
                return confirm(gems, end, start)
            }
            gems.toHashSet().forEach { hm[it] = false }
            for (i in start-1 until end) {
                hm[gems[i]] = true
            }
            return hm.toList().all { it.second }
        }
    }
}
