# coding=utf-8
# Date: 2021/5/23 21:28
from typing import List


# 执行用时：60 ms, 在所有 Python3 提交中击败了7.91%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了24.78%的用户
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []

        path = [0] * len(nums)
        st = [False] * len(nums)
        self.dfs(nums, 0, path, st, ans)
        return ans

    def dfs(self, nums, u, path, st, ans):
        if u == len(nums):
            ans.append(path.copy())
            return
        for i in range(len(nums)):
            if not st[i]:
                path[u] = nums[i]
                st[i] = True
                self.dfs(nums, u + 1, path, st, ans)
                st[i] = False


if __name__ == "__main__":
    print(Solution().permute([1, 2, 3]))
