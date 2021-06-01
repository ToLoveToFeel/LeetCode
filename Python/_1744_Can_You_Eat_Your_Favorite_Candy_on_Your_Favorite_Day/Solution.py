# coding=utf-8
# Date: 2021/6/1 10:41
from typing import List


# 执行用时：272 ms, 在所有 Python3 提交中击败了16.67%的用户
# 内存消耗：52.9 MB, 在所有 Python3 提交中击败了98.15%的用户
class Solution:
    def canEat(self, candiesCount: List[int], queries: List[List[int]]) -> List[bool]:
        n = len(candiesCount)
        s = [0 for _ in range(n + 1)]
        for i in range(1, n + 1):
            s[i] = s[i - 1] + candiesCount[i - 1]
        res = [False for _ in range(len(queries))]
        for i in range(len(queries)):
            q = queries[i]
            type = q[0]; day = q[1]; cap = q[2]
            x1 = day + 1; y1 = (day + 1) * cap
            x2 = s[type] + 1; y2 = s[type + 1]
            res[i] = not (x1 > y2 or x2 > y1)
        return res


if __name__ == "__main__":
    candiesCount = [7, 4, 5, 3, 8]
    queries = [[0, 2, 2], [4, 2, 4], [2, 13, 1000000000]]
    print(Solution().canEat(candiesCount, queries))
