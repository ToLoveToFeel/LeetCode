# coding=utf-8
# Date: 2021/6/21 11:01
from typing import List


# 执行用时：60 ms, 在所有 Python3 提交中击败了11.52%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了72.35%的用户
class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        res = []
        for i in range(1 << 10):
            s = 0
            for j in range(10):
                if i >> j & 1:
                    s += 1
            if s == turnedOn:
                a = i >> 6
                b = i & 63
                if a < 12 and b < 60:
                    res.append(str(a) + ":" + ("0" if b < 10 else "") + str(b))
        return res


if __name__ == "__main__":
    print(Solution().readBinaryWatch(1))
