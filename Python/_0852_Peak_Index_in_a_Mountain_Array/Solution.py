# coding=utf-8
# Date: 2021/6/15 8:46
from typing import List


# 执行用时：40 ms, 在所有 Python3 提交中击败了74.95%的用户
# 内存消耗：15.8 MB, 在所有 Python3 提交中击败了34.92%的用户
class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        n = len(arr)
        l = 0; r = n - 2
        while l < r:
            mid = l + r >> 1
            if arr[mid] > arr[mid + 1]:
                r = mid
            else:
                l = mid + 1
        return l


if __name__ == "__main__":
    print(Solution().peakIndexInMountainArray([24, 69, 100, 99, 79, 78, 67, 36, 26, 19]))  # 2
