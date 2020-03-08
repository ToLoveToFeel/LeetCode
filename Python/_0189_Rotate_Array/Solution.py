# coding=utf-8
# @Time       : 2020/3/8
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode
# 旋转数组


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        if k % len(nums) == 0:
            return

        k = k % len(nums)
        nums.reverse()
        nums[:k] = list(reversed(nums[:k]))
        nums[k:] = list(reversed(nums[k:]))


if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3
    So = Solution()
    So.rotate(nums, k)
    print(nums)


