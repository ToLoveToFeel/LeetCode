# coding=utf-8
# Date: 2021/8/16 10:03


# 执行用时：260 ms, 在所有 Python3 提交中击败了84.77%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了25.93%的用户
class Solution:
    def countArrangement(self, n: int) -> int:
        f = [0 for _ in range(1 << n)]
        f[0] = 1
        for i in range(1 << n):
            k = 0
            for j in range(n):
                if i >> j & 1:
                    k += 1
            for j in range(n):
                if not (i >> j & 1):
                    if (j + 1) % (k + 1) == 0 or (k + 1) % (j + 1) == 0:
                        f[i | (1 << j)] += f[i]
        return f[(1 << n) - 1]


if __name__ == "__main__":
    print(Solution().countArrangement(2))  # 2
