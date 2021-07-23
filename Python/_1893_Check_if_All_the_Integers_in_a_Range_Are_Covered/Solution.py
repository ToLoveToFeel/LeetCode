# coding=utf-8
# Date: 2021/7/23 9:04
from typing import List


# 执行用时：20 ms, 在所有 Python3 提交中击败了100.00%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了6.05%的用户
class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        cnt = [0] * 60
        for rg in ranges:
            cnt[rg[0]] += 1
            cnt[rg[1] + 1] -= 1
        sum = 0
        for i in range(1, 51):
            sum += cnt[i]
            if left <= i <= right and sum <= 0:
                return False
        return True


if __name__ == "__main__":
    print(Solution().isCovered([[1, 2], [3, 4], [5, 6]], 2, 5))  # True
