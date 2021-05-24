# coding=utf-8
from typing import List


class Solution:
    def insert(self, a: List[List[int]], b: List[int]) -> List[List[int]]:
        res = []
        k = 0
        while k < len(a) and a[k][1] < b[0]:
            res.append(a[k])
            k += 1

        if k < len(a):
            b[0] = min(a[k][0], b[0])
            while k < len(a) and a[k][0] <= b[1]:
                b[1] = max(b[1], a[k][1])
                k += 1
        res.append(b)

        while k < len(a):
            res.append(a[k])
            k += 1
        return res


if __name__ == "__main__":
    a = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
    b = [4, 8]
    print(Solution().insert(a, b))  # [[1, 2], [3, 10], [12, 16]]
