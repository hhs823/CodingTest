def solution(stones, k):
    answer = 0
    left, right = 0, 200000000

    while left <= right:
        mid = (left + right) // 2
        s = list(stones)

        for i in range(len(s)):
            s[i] -= mid

        seq_minus, max_minus = 0, 0
        for i in range(len(s)):
            if s[i] < 0:
                seq_minus += 1
                max_minus = max(max_minus, seq_minus)
            else:
                seq_minus = 0

        if max_minus < k:
            if answer < mid:
                answer = mid
            left = mid + 1
        else:
            right = mid - 1

    return answer


print(solution([2, 2], 1))
# print(count_blank([0, 4, 5, 3, 0, 0, 4, 0, 5, 0]))
