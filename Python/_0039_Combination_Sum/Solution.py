# coding=utf-8
# Date: 2021/5/22 10:37
from typing import List


# 执行用时：132 ms, 在所有 Python3 提交中击败了14.16%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了90.05%的用户
class Solution:
    def combinationSum(self, c: List[int], target: int) -> List[List[int]]:
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

        i = 0
        while c[u] * i <= target:
            self.dfs(c, target - c[u] * i, u + 1, path, ans)
            path.append(c[u])
            i += 1

        i = 0
        while c[u] * i <= target:
            path.pop(len(path) - 1)
            i += 1


if __name__ == "__main__":
    print(Solution().combinationSum([2, 3, 6, 7], 7))  # [[7], [2, 2, 3]]
