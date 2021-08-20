# coding=utf-8
# Date: 2021/8/20 10:06


# 执行用时：32 ms, 在所有 Python3 提交中击败了88.25%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了92.02%的用户
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        res = ""
        for i in range(0, len(s), k * 2):
            res += s[i:min(i + k, len(s))][::-1]
            if i + k < len(s):
                res += s[i + k:min(i + k * 2, len(s))]
        return res


if __name__ == "__main__":
    print(Solution().reverseStr("abcd", 2))  # bacd
    print(Solution().reverseStr("abcd", 3))  # cbad
    print(Solution().reverseStr("abcd", 4))  # dcba
    print(Solution().reverseStr("abcd", 5))  # dcba
