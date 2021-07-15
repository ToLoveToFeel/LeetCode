# coding=utf-8
# Date: 2021/7/15 10:06
from typing import List


# 执行用时：92 ms, 在所有 Python3 提交中击败了88.73%的用户
# 内存消耗：21.6 MB, 在所有 Python3 提交中击败了21.53%的用户
class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        n = len(arr)
        arr.sort()
        arr[0] = 1
        for i in range(1, n):
            if arr[i] > arr[i - 1] + 1:
                arr[i] = arr[i - 1] + 1
        return arr[n - 1]


if __name__ == "__main__":
    print(Solution().maximumElementAfterDecrementingAndRearranging([2, 2, 1, 2, 1]))  # 2
