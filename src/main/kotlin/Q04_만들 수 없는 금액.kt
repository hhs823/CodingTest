fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val coins = br.readLine().split(" ").map { it.toInt() }.sorted()

    var target = 1
    for(coin in coins) {
        if(target < coin) break
        target += coin
    }

    print(target)
}
