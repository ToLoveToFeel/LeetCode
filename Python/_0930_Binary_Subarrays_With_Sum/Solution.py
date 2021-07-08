# coding=utf-8
# Date: 2021/7/8 9:31
from typing import List


# 执行用时：284 ms, 在所有 Python3 提交中击败了36.55%的用户
# 内存消耗：18.6 MB, 在所有 Python3 提交中击败了14.22%的用户
class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        n = len(nums)
        s = [0 for _ in range(n + 1)]
        for i in range(1, n + 1):
            s[i] = s[i - 1] + nums[i - 1]

        res = 0
        cnt = {}
        for i in range(1, n + 1):
            if s[i - 1] not in cnt:
                cnt[s[i - 1]] = 0
            cnt[s[i - 1]] += 1
            if s[i] - goal in cnt:
                res += cnt[s[i] - goal]
        return res


if __name__ == "__main__":
    print(Solution().numSubarraysWithSum([1, 0, 1, 0, 1], 2))  # 4
