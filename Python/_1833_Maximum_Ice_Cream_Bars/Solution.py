# coding=utf-8
# Date: 2021/7/2 9:53
from typing import List


# 执行用时：196 ms, 在所有 Python3 提交中击败了18.00%的用户
# 内存消耗：24.7 MB, 在所有 Python3 提交中击败了84.29%的用户
class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        n = len(costs)
        costs.sort()
        cnt = 0
        while cnt < n and costs[cnt] <= coins:
            coins -= costs[cnt]
            cnt += 1
        return cnt


if __name__ == "__main__":
    print(Solution().maxIceCream([1, 3, 2, 4, 1], 7))
