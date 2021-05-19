# coding=utf-8


# 执行用时：956 ms, 在所有 Python3 提交中击败了70.87%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了87.26%的用户
class Solution:
    def longestPalindrome(self, s: str) -> str:
        start = 0
        length = 1
        for i in range(len(s)):
            curL = max(self.expand(s, i, i), self.expand(s, i, i + 1))
            if curL > length:
                length = curL
                start = i - (curL - 1) // 2
        return s[start: start + length]

    def expand(self, s, i, j):
        while i >= 0 and j < len(s):
            if s[i] != s[j]:
                break
            i -= 1
            j += 1
        return j - i - 1


if __name__ == "__main__":
    print(Solution().longestPalindrome("babad"))
