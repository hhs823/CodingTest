fun main() {
    class Solution {
        fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
            // 원 형태를 길이를 2배로 늘린 배열로 변형
            var extended = weak + IntArray(weak.size) { weak[it] + n }

            var answer = dist.size + 1
            // 가능한 모든 순열
            val permutation = permutation(dist.toList())
            // 모든 시작 위치에 대해서
            for (start in weak.indices) {
                for (friends in permutation) {
                    var count = 1
                    var position = extended[start] + friends[count - 1]
                    for (index in start until start + weak.size) {
                        // 점검 위치를 초과한 경우
                        if (position < extended[index]) {
                            count += 1
                            if (count > dist.size) break // 모든 사람을 투입한 경우
                            position = extended[index] + friends[count - 1]
                        }
                    }
                    if (answer > count) answer = count
                }
            }
            if (answer > dist.size) return -1
            return answer
        }

        fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> =
            if (sub.isEmpty()) listOf(fin)
            else sub.flatMap { permutation(el, fin + it, sub - it) }


    }
}