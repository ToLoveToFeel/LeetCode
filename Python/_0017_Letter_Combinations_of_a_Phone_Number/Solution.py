# coding=utf-8
from typing import List

strs = [
    "", "", "abc", "def",
    "ghi", "jkl", "mno",
    "pqrs", "tuv", "wxyz",
]
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        ans = []
        if not digits:
            return ans
        self.dfs(ans, digits, 0, "")
        return ans

    def dfs(self, ans, digits, u, path):
        if u == len(digits):
            ans.append(path)
        else:
            for c in strs[ord(digits[u]) - ord('0')]:
                self.dfs(ans, digits, u + 1, path + c)


if __name__ == "__main__":
    print(Solution().letterCombinations(""))
    print(Solution().letterCombinations("23"))
