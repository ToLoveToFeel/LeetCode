# coding=utf-8


# 执行用时：80 ms, 在所有 Python3 提交中击败了56.19%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了94.00%的用户
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        f = [0 for _ in range(256)]
        j = res = 0
        for i in range(len(s)):
            f[ord(s[i])] += 1
            while f[ord(s[i])] > 1:
                f[ord(s[j])] -= 1
                j += 1
            res = max(res, i - j + 1)
        return res


if __name__ == "__main__":
    print(Solution().lengthOfLongestSubstring("abcabcbb"))

