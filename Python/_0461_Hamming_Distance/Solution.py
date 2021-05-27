# coding=utf-8
# Date: 2021/5/27 9:04


# 执行用时：28 ms, 在所有 Python3 提交中击败了98.92%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了5.57%的用户
class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        res = 0
        for i in range(30, -1, -1):
            if (x >> i & 1) ^ (y >> i & 1):
                res += 1
        return res


if __name__ == "__main__":
    print(Solution().hammingDistance(1, 4))  # 2
