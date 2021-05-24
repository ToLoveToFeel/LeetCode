# coding=utf-8


class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        return len(s.strip(" ").split(' ')[-1])


if __name__ == "__main__":
    print(Solution().lengthOfLastWord(" "))
    print(Solution().lengthOfLastWord("Hello World"))
