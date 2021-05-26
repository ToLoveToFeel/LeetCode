# coding=utf-8
from typing import List


class Solution:
    def merge(self, a: List[List[int]]) -> List[List[int]]:
        a.sort()
        res = []
        l = a[0][0]; r = a[0][1]
        for i in range(len(a)):
            if a[i][0] > r:
                res.append([l, r])
                l = a[i][0]; r = a[i][1]
            else:
                r = max(r, a[i][1])
        res.append([l, r])
        return res


if __name__ == "__main__":
    print(Solution().merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
