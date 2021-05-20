# coding=utf-8
from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ""
        for i in range(len(strs[0])):
            c = strs[0][i]
            for s in strs:
                if i >= len(s) or s[i] != c:
                    return res
            res += c
        return res


if __name__ == "__main__":
    strs = ["flower", "flow", "flight"]
    print(Solution().longestCommonPrefix(strs))  # fl
