# coding=utf-8
# Date: 2021/6/23 9:04


# 执行用时：40 ms, 在所有 Python3 提交中击败了71.25%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了5.24%的用户
class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        for i in range(32):
            res += (n >> i & 1)
        return res


if __name__ == "__main__":
    print(Solution().hammingWeight(13))  # 3
    print(Solution().hammingWeight(0b11111111111111111111111111111101))  # 31
