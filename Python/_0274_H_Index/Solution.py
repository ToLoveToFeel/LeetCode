# coding=utf-8
# Date: 2021/7/11 9:20
from typing import List


# 执行用时：32 ms, 在所有 Python3 提交中击败了95.64%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了19.62%的用户
class Solution:
    def hIndex(self, cs: List[int]) -> int:
        cs.sort(reverse=True)
        for h in range(len(cs), 0, -1):
            if cs[h - 1] >= h:
                return h
        return 0


if __name__ == "__main__":
    print(Solution().hIndex([3, 0, 6, 1, 5]))  # 3
