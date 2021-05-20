# coding=utf-8
from typing import List

# 测试和提交时输出的结果不同，系统bug?
ans = []
strs = [
    "", "", "abc", "def",
    "ghi", "jkl", "mno",
    "pqrs", "tuv", "wxyz",
]
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return ans
        self.dfs(digits, 0, "")
        return ans

    def dfs(self, digits, u, path):
        if u == len(digits):
            ans.append(path)
        else:
            for c in strs[ord(digits[u]) - ord('0')]:
                self.dfs(digits, u + 1, path + c)


if __name__ == "__main__":
    print(Solution().letterCombinations(""))
    print(Solution().letterCombinations("23"))
