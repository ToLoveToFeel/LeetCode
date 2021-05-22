# coding=utf-8
# Date: 2021/5/22 10:46
from typing import List


class Solution:
    def combinationSum2(self, c: List[int], target: int) -> List[List[int]]:
        c.sort()

        ans = []
        path = []
        self.dfs(c, target, 0, path, ans)
        return ans

    def dfs(self, c, target, u, path, ans):
        if target == 0:
            ans.append(path.copy())
            return
        if u == len(c):
            return

        k = u + 1
        while k < len(c) and c[k] == c[u]:
            k += 1
        cnt = k - u

        i = 0
        while i <= cnt and c[u] * i <= target:
            self.dfs(c, target - c[u] * i, k, path, ans)
            path.append(c[u])
            i += 1

        i = 0
        while i <= cnt and c[u] * i <= target:
            path.pop(len(path) - 1)
            i += 1


if __name__ == "__main__":
    print(Solution().combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))  # [[2, 6], [1, 7], [1, 2, 5], [1, 1, 6]]
