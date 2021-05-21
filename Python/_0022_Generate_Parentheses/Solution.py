# coding=utf-8
from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        self.dfs(ans, n, 0, 0, "")
        return ans

    def dfs(self, ans, n, lc, rc, seq):
        if lc == n and rc == n:
            ans.append(seq)
        else:
            if lc < n:
                self.dfs(ans, n, lc + 1, rc, seq + '(')
            if rc < n and lc > rc:
                self.dfs(ans, n, lc, rc + 1, seq + ')')


if __name__ == "__main__":
    print(Solution().generateParenthesis(3))  # ['((()))', '(()())', '(())()', '()(())', '()()()']
