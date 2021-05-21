# coding=utf-8
# Date: 2021/5/21 19:46


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        return haystack.find(needle)


if __name__ == "__main__":
    print(Solution().strStr("", ""))  # 0
    print(Solution().strStr("hello", "ll"))  # 2
    print(Solution().strStr("aaaaa", "bba"))  # -1
    print(Solution().strStr("mississippi", "issippi"))  # 4
