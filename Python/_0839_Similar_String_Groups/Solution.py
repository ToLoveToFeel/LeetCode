# coding=utf-8
# Date: 2021/6/6 15:02
from typing import List


# 执行用时：284 ms, 在所有 Python3 提交中击败了75.18%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了75.91%的用户
class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        n = len(strs)
        p = [i for i in range(n)]
        res = n
        for i in range(n):
            for j in range(i):
                p1 = self.find(p, i); p2 = self.find(p, j)
                if p1 != p2 and self.is_similar(strs[i], strs[j]):
                    p[p1] = p2
                    res -= 1
        return res

    def find(self, p, x):
        if p[x] != x:
            p[x] = self.find(p, p[x])
        return p[x]

    def is_similar(self, a, b):
        cnt = 0
        for i in range(len(a)):
            if a[i] != b[i]:
                cnt += 1
                if cnt > 2:
                    return False
        return True


if __name__ == "__main__":
    print(Solution().numSimilarGroups(["tars", "rats", "arts", "star"]))  # 2
