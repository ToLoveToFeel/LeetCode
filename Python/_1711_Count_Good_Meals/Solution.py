# coding=utf-8
# Date: 2021/7/7 9:41
from typing import List


# 执行用时：1132 ms, 在所有 Python3 提交中击败了63.31%的用户
# 内存消耗：20.4 MB, 在所有 Python3 提交中击败了62.59%的用户
class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        n = len(deliciousness)
        mod = int(1e9) + 7

        s = [0 for _ in range(22)]
        p = 1
        for i in range(22):
            s[i] = p
            p *= 2

        res = 0
        hash = {}
        for val in deliciousness:
            for i in range(22):
                t = s[i] - val
                if t in hash:
                    res = (res + hash[t]) % mod
            if val not in hash:
                hash[val] = 0
            hash[val] += 1
        return res


if __name__ == "__main__":
    print(Solution().countPairs([1, 3, 5, 7, 9]))  # 4
