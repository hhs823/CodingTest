fun failure(pattern: String): IntArray {
    var j = 0
    val result = IntArray(pattern.length) { 0 }

    for (i in 1 until pattern.length) {
        while (j > 0 && pattern[i] != pattern[j]) j = result[j - 1]
        if (pattern[i] == pattern[j]) result[i] = ++j
    }

    return result
}

fun kmp(s: String, p: String): IntArray {
    var result = intArrayOf()
    val f = failure(p)

    val n = s.length
    val m = p.length
    var j = 0

    for (i in 0 until n) {
        while (j > 0 && s[i] != p[j]) j = f[j - 1]
        if (s[i] == p[j]) {
            if (j == m - 1) {
                result += i - m + 1
                j = f[j]
            } else {
                j++
            }
        }
    }
    return result
}