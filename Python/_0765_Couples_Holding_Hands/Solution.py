# coding=utf-8
# Date: 2021/6/6 14:15
from typing import List


class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        n = len(row) // 2
        p = [i for i in range(n)]
        cnt = n
        for i in range(0, n * 2, 2):
            a = self.find(p, row[i] // 2)
            b = self.find(p, row[i + 1] // 2)
            if a != b:
                p[a] = b
                cnt -= 1
        return n - cnt

    def find(self, p, x):
        if p[x] != x:
            p[x] = self.find(p, p[x])
        return p[x]


if __name__ == "__main__":
    print(Solution().minSwapsCouples([0, 2, 1, 3]))  # 1
