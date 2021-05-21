# coding=utf-8
# Date: 2021/5/21 20:08


# 执行用时：44 ms, 在所有 Python3 提交中击败了60.54%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了85.07%的用户
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        HALF_INT_MIN = -1073741824
        x = dividend; y = divisor
        sign = (x > 0) ^ (y > 0)
        if x > 0:
            x = -x
        if y > 0:
            y = -y

        ys = []
        t1 = y; t2 = -1
        while t1 >= x:
            ys.append([t1, t2])
            if t1 < HALF_INT_MIN:
                break
            t1 += t1
            t2 += t2

        res = 0
        for i in range(len(ys) - 1, -1, -1):
            if x <= ys[i][0]:
                x -= ys[i][0]
                res += ys[i][1]
        if not sign:
            if res == int(-pow(2, 31)):
                return int(pow(2, 31) - 1)
            res = -res
        return res


if __name__ == "__main__":
    print(Solution().divide(-2147483648, 1))  # -2147483648
