# coding=utf-8
# Date: 2021/6/6 11:17
from typing import List


# 执行用时：76 ms, 在所有 Python3 提交中击败了28.55%的用户
# 内存消耗：15.3 MB, 在所有 Python3 提交中击败了41.00%的用户
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        p = [i for i in range(210)]  # 并查集

        n = len(isConnected)
        res = n
        for i in range(n):
            for j in range(i):
                p1 = self.find(p, i); p2 = self.find(p, j)
                if isConnected[i][j] == 1 and p1 != p2:
                    res -= 1
                    p[p1] = p2
        return res

    def find(self, p, x):
        if x != p[x]:
            p[x] = self.find(p, p[x])
        return p[x]


if __name__ == "__main__":
    isConnected = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
    print(Solution().findCircleNum(isConnected))  # 2
