# coding=utf-8


# 执行用时：76 ms, 在所有 Python3 提交中击败了58.76%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了80.07%的用户
class Solution:
    def isPalindrome(self, x: int) -> bool:
        return str(x) == str(x)[::-1]


if __name__ == "__main__":
    print(Solution().isPalindrome(121))  # True
    print(Solution().isPalindrome(-121))  # False
