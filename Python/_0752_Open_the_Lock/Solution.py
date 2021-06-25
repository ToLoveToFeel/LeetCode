# coding=utf-8
# Date: 2021/6/25 9:24
from typing import List


# 执行用时：608 ms, 在所有 Python3 提交中击败了82.92%的用户
# 内存消耗：15.9 MB, 在所有 Python3 提交中击败了77.36%的用户
class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        start = "0000"
        if start == target:
            return 0
        S = set()
        for s in deadends:
            S.add(s)
        if start in S:
            return -1

        q = [start]
        dist = {start: 0}
        while len(q) != 0:
            t = q[0]
            q.pop(0)
            for i in range(4):
                for j in range(-1, 2, 2):
                    s = list(t)
                    s[i] = chr((ord(s[i]) - ord('0') + j + 10) % 10 + ord('0'))
                    state = "".join(s)
                    if state not in S and state not in dist:
                        dist[state] = dist[t] + 1
                        if state == target:
                            return dist[state]
                        q.append(state)
        return -1


if __name__ == "__main__":
    deadends = ["0201", "0101", "0102", "1212", "2002"]
    target = "0202"
    print(Solution().openLock(deadends, target))  # 6
