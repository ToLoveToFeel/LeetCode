# coding=utf-8
# Date: 2021/6/6 15:17
from typing import List


# 执行用时：1596 ms, 在所有 Python3 提交中击败了16.51%的用户
# 内存消耗：15.4 MB, 在所有 Python3 提交中击败了55.51%的用户
class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        n = len(stones)
        p = [i for i in range(n)]
        cnt = n
        for i in range(n):
            for j in range(i):
                if stones[i][0] == stones[j][0] or stones[i][1] == stones[j][1]:
                    p1 = self.find(p, i); p2 = self.find(p, j)
                    if p1 != p2:
                        p[p1] = p2
                        cnt -= 1
        return n - cnt

    def find(self, p, x):
        if p[x] != x:
            p[x] = self.find(p, p[x])
        return p[x]


if __name__ == "__main__":
    stones = [[0, 0], [0, 1], [1, 0], [1, 2], [2, 1], [2, 2]]
    print(Solution().removeStones(stones))  # 5
