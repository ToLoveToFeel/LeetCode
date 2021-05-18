# coding=utf-8
from typing import List


# 执行用时：60 ms, 在所有 Python3 提交中击败了36.93%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了31.23%的用户
class Solution:
    def findMedianSortedArrays(self, A: List[int], B: List[int]) -> float:
        n = len(A) + len(B)
        if n % 2 == 1:
            return self.get(A, B, n // 2 + 1)
        else:
            l = self.get(A, B, n // 2)
            r = self.get(A, B, n // 2 + 1)
            return (l + r) / 2

    def get(self, A, B, k):
        i = 0
        j = 0
        while True:
            if i == len(A):
                return B[j + k - 1]
            if j == len(B):
                return A[i + k - 1]
            if k == 1:
                return min(A[i], B[j])

            newI = min(i + k // 2, len(A)) - 1
            newJ = min(j + k // 2, len(B)) - 1
            if A[newI] <= B[newJ]:
                k -= (newI - i + 1)
                i = newI + 1
            else:
                k -= (newJ - j + 1)
                j = newJ + 1


if __name__ == "__main__":
    print(Solution().findMedianSortedArrays([1, 3], [2]))  # 2
    print(Solution().findMedianSortedArrays([1, 2], [3, 4]))  # 2.5
