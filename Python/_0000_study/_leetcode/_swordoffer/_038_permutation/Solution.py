# coding=utf-8
# Date: 2021/6/22 9:30
from typing import List


# 执行用时：236 ms, 在所有 Python3 提交中击败了26.06%的用户
# 内存消耗：16.8 MB, 在所有 Python3 提交中击败了91.45%的用户
class Solution:
    def __init__(self):
        self.ans = []
        self.st = []

    def permutation(self, s: str) -> List[str]:
        n = len(s)
        self.st = [False for _ in range(n)]
        s = "".join((lambda x: (x.sort(), x)[1])(list(s)))
        self.dfs(s, 0, "")
        return self.ans

    def dfs(self, s, cnt, path):
        if cnt == len(s):
            self.ans.append(path)
            return
        for i in range(len(s)):
            if not self.st[i]:
                if i > 0 and s[i] == s[i - 1] and not self.st[i - 1]:
                    continue
                self.st[i] = True
                self.dfs(s, cnt + 1, path + s[i])
                self.st[i] = False


if __name__ == "__main__":
    print(Solution().permutation("abc"))
    print(Solution().permutation("aab"))
