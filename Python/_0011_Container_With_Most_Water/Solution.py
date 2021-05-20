# coding=utf-8
from typing import List


class Solution:
    def maxArea(self, h: List[int]) -> int:
        res = 0
        i = 0; j = len(h) - 1
        while i < j:
            res = max(res, min(h[i], h[j]) * (j - i))
            if h[i] > h[j]:
                j -= 1
            else:
                i += 1
        return res


if __name__ == "__main__":
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print(Solution().maxArea(height))  # 49
