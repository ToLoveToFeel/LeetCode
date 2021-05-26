# coding=utf-8
# Date: 2021/5/26 16:44
from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        digits = digits[::-1]
        t = 1
        for i in range(len(digits)):
            t += digits[i]
            digits[i] = t % 10
            t //= 10
        if t != 0:
            digits.append(t)
        return digits[::-1]


if __name__ == "__main__":
    print(Solution().plusOne([9, 9]))  # [1, 0, 0]
