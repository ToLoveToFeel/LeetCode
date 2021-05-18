# coding=utf-8
from typing import List


# 执行用时：60 ms, 在所有 Python3 提交中击败了62.74%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了75.16%的用户
class Solution:
    def countTriplets(self, arr: List[int]) -> int:

        n = len(arr)
        s = [0 for _ in range(n + 1)]
        for i in range(1, n + 1):
            s[i] = s[i - 1] ^ arr[i - 1]

        res = 0
        for i in range(0, n + 1):
            for k in range(i + 2, n + 1):
                if (s[i] ^ s[k]) == 0:
                    res += k - i - 1
        return res


if __name__ == "__main__":
    print(Solution().countTriplets([2, 3, 1, 6, 7]))  # 4
