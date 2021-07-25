# coding=utf-8
# Date: 2021/7/25 10:22
from typing import List


# 执行用时：204 ms, 在所有 Python3 提交中击败了100.00%的用户
# 内存消耗：55 MB, 在所有 Python3 提交中击败了88.16%的用户
class Solution:
    def restoreArray(self, aps: List[List[int]]) -> List[int]:
        dic = {}
        for e in aps:
            if e[0] not in dic:
                dic[e[0]] = []
            if e[1] not in dic:
                dic[e[1]] = []
            dic[e[0]].append(e[1])
            dic[e[1]].append(e[0])
        n = len(aps) + 1
        res = [0] * n
        for k, v in dic.items():
            if len(v) == 1:
                res[0] = k
                break
        res[1] = dic[res[0]][0]
        for i in range(2, n):
            t = dic[res[i - 1]]
            if res[i - 2] == t[0]:
                res[i] = t[1]
            else:
                res[i] = t[0]
        return res


if __name__ == "__main__":
    print(Solution().restoreArray([[2, 1], [3, 4], [3, 2]]))
