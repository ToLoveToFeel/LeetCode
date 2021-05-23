# coding=utf-8
# Date: 2021/5/23 21:38
from typing import List


# 执行用时：36 ms, 在所有 Python3 提交中击败了99.42%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了81.68%的用户
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:

        nums.sort()
        ans = []

        path = [0 for _ in range(len(nums))]
        st = [False for _ in range(len(nums))]
        self.dfs(nums, 0, path, st, ans)
        return ans

    def dfs(self, nums, u, path, st, ans):
        if u == len(nums):
            ans.append(path.copy())
            return
        for i in range(len(nums)):
            if not st[i]:
                if i > 0 and nums[i] == nums[i - 1] and not st[i - 1]:
                    continue
                path[u] = nums[i]
                st[i] = True
                self.dfs(nums, u + 1, path, st, ans)
                st[i] = False


if __name__ == "__main__":
    print(Solution().permuteUnique([1, 1, 2]))  # [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
