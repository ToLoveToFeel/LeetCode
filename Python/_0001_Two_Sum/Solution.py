# coding=utf-8
# python3 函数指定类型：https://blog.csdn.net/sgyuanshi/article/details/96192887

from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash = {}
        for i, x in enumerate(nums):
            r = target - x
            if r in hash:
                return [hash[r], i]
            hash[x] = i
        return []


if __name__ == "__main__":
    print(Solution().twoSum([2, 7, 11, 15], 9))  # [0, 1]
