# coding=utf-8


# 执行用时：60 ms, 在所有 Python3 提交中击败了16.16%的用户
# 内存消耗：16.4 MB, 在所有 Python3 提交中击败了5.06%的用户KMP
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        if len(needle) > len(haystack):
            return -1

        n = len(needle); m = len(haystack)
        p = " " + needle; s = " " + haystack
        ne = [0 for _ in range(n + 10)]

        j = 0
        for i in range(2, n + 1):
            while j > 0 and p[i] != p[j + 1]:
                j = ne[j]
            if p[i] == p[j + 1]:
                j += 1
            ne[i] = j

        j = 0
        for i in range(1, m + 1):
            while j > 0 and s[i] != p[j + 1]:
                j = ne[j]
            if s[i] == p[j + 1]:
                j += 1
            if j == n:
                return i - n
        return -1


if __name__ == "__main__":
    print(Solution().strStr("", ""))  # 0
    print(Solution().strStr("hello", "ll"))  # 2
    print(Solution().strStr("aaaaa", "bba"))  # -1
    print(Solution().strStr("mississippi", "issippi"))  # 4
