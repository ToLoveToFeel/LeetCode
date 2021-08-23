# coding=utf-8
# Date: 2021/8/23 10:31


# 执行用时：24 ms, 在所有 Python3 提交中击败了97.17%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了49.01%的用户
class Solution:
    def getMaximumGenerated(self, n: int) -> int:
        if n == 0:
            return 0
        nums = [0] * (n + 1)
        nums[1] = 1
        for i in range(1, n + 1):
            if i * 2 <= n:
                nums[i * 2] = nums[i]
            if i * 2 + 1 <= n:
                nums[i * 2 + 1] = nums[i] + nums[i + 1]

        res = 0
        for x in nums:
            res = max(res, x)
        return res


if __name__ == "__main__":
    print(Solution().getMaximumGenerated(7))  # 3
    print(Solution().getMaximumGenerated(2))  # 1
    print(Solution().getMaximumGenerated(3))  # 2
