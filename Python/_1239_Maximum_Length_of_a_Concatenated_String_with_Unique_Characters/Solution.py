# coding=utf-8
# Date: 2021/6/19 9:59
from typing import List


# 执行用时：88 ms, 在所有 Python3 提交中击败了84.72%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了59.80%的用户
class Solution:
    def __init__(self):
        self.state = []
        self.st = []
        self.res = 0

    def maxLength(self, arr: List[str]) -> int:
        n = len(arr)
        self.state = [0 for _ in range(n)]
        self.st = [False for _ in range(n)]
        for i in range(n):
            for c in arr[i]:
                bit = 1 << (ord(c) - ord('a'))
                if (self.state[i] & bit) != 0:
                    self.st[i] = True
                    break
                self.state[i] |= bit
        self.dfs(arr, 0, 0, 0)
        return self.res

    def dfs(self, arr, u, cnt, t):
        if u == len(arr):
            self.res = max(self.res, cnt)
            return
        self.dfs(arr, u + 1, cnt, t)
        if (t & self.state[u]) == 0 and not self.st[u]:
            self.dfs(arr, u + 1, cnt + len(arr[u]), t | self.state[u])


if __name__ == "__main__":
    print(Solution().maxLength(["un", "iq", "ue"]))  # 4
