def solution(n, k, cmd):
    stack = []
    answer = ['O' for _ in range(n)]
    now = k

    for s in cmd:
        slt = s.split(" ")
        if slt[0] == "U":
            for _ in range(int(slt[1])):
                now -= 1
                while answer[now] == 'X':
                    now -= 1
        elif slt[0] == "D":
            for _ in range(int(slt[1])):
                now += 1
                while answer[now] == 'X':
                    now += 1
        elif slt[0] == "C":
            answer[now] = 'X'
            stack.append(now)
            while now < n and answer[now] == 'X':
                now += 1
            if now == n:
                while now > -1 and answer[now] == 'X':
                    now -= 1
        else:
            t = stack.pop()
            answer[t] = 'O'

    return ''.join(answer)
