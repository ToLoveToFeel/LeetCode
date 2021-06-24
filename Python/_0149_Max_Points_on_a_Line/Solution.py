# coding=utf-8
# Date: 2021/6/24 10:56
from typing import List


# 执行用时：88 ms, 在所有 Python3 提交中击败了26.28%的用户
# 内存消耗：14.8 MB, 在所有 Python3 提交中击败了91.91%的用户
class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        res = 0
        for p in points:
            ss = 0
            vs = 0
            cnt = {}
            for q in points:
                if p == q:
                    ss += 1
                elif p[0] == q[0]:
                    vs += 1
                else:
                    k = (q[1] - p[1]) / (q[0] - p[0])
                    if k in cnt:
                        cnt[k] += 1
                    else:
                        cnt[k] = 1
            c = vs
            for k, v in cnt.items():
                c = max(c, v)
            res = max(res, c + ss)
        return res


if __name__ == "__main__":
    print(Solution().maxPoints([[1, 1], [2, 2], [3, 3]]))  # 3
