import kotlin.math.max

val visit = Array(10001) { false }
val dp = Array(10001) { Array(2) { 0 } }
val W = Array(10001) { 0 }
val graph = arrayOf(intArrayOf())

fun dfs(cur: Int) {
    // 이미 방문한 위치는 진행하지 않는다
    if (visit[cur]) return

    // 처음 들어온 cur 노드에 대해 일반 마을과 우수 마을일 떄 인구수를 초기화
    // 우수 마을을 구하는 것이므로 인구수는 우수마을일 때만 설정한다.
    visit[cur] = true
    dp[cur][0] = 0
    dp[cur][1] = W[cur]

    // cur에 인접한 자식 노드들에 대하여
    for(next in graph[cur]) {
        if(visit[next]) continue    // 방문하지 않은 노드에만 접근

        dfs(next)

        // 일반 마을은 자식 마을이 우수거나, 자식 마을이 일반 마을
        // 더 큰 쪽을 선택한다.
        dp[cur][0] = dp[cur][0] + max(dp[next][0], dp[next][1])

        // 현재 마을이 우수 마을이면, 자식은 반드시 일반 마을
        dp[cur][1] = dp[cur][1] + dp[next][0]
    }
    
}