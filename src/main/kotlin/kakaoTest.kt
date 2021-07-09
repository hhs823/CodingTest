import java.util.*
import kotlin.math.abs

val br = System.`in`.bufferedReader()

fun main() {
    val n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    val arr = Array(n) { st.nextToken().toInt() }
    var (left, right) = listOf(0, n - 1)
    var (aleft, aright) = listOf(0, n - 1)

    var minimum = Int.MAX_VALUE
    while (left < right) {
        val sum = arr[left] + arr[right]
        if (sum == 0) {
            aleft = left
            aright = right
            break
        }
        val abs = abs(sum.toDouble()).toInt()
        when {
            abs < minimum -> {
                aleft = left
                aright = right
                minimum = abs
            }
            sum < 0 -> {
                left += 1
            }
            else -> {
                right -= 1
            }
        }
    }

    print("${arr[aleft]} ${arr[aright]}")
}