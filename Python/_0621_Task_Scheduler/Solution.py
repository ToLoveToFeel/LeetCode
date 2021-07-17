# coding=utf-8
# Date: 2021/7/17 15:39
from typing import List


# 执行用时：80 ms, 在所有 Python3 提交中击败了72.71%的用户
# 内存消耗：16.4 MB, 在所有 Python3 提交中击败了37.97%的用户
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hash = {}
        for c in tasks:
            if c not in hash:
                hash[c] = 0
            hash[c] += 1
        maxc, cnt = 0, 0
        for k, v in hash.items():
            maxc = max(maxc, v)
        for k, v in hash.items():
            if maxc == v:
                cnt += 1
        return max(len(tasks), (maxc - 1) * (n + 1) + cnt)


if __name__ == "__main__":
    pass
