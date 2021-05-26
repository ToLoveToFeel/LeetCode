# coding=utf-8
# Date: 2021/5/26 16:49


class Solution:
    def mySqrt(self, x: int) -> int:
        l = 0; r = x
        while l < r:
            mid = (r - l + 1) // 2 + l
            if mid <= x // mid:
                l = mid
            else:
                r = mid - 1
        return r


if __name__ == "__main__":
    print(Solution().mySqrt(2147395599))
