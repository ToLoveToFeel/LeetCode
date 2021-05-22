# coding=utf-8
# Date: 2021/5/22 11:11


# 执行用时：88 ms, 在所有 Python3 提交中击败了65.28%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了8.38%的用户
class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n = len(num1); m = len(num2)
        A = []; B = []
        for i in range(n - 1, -1, -1):
            A.append(ord(num1[i]) - ord('0'))
        for i in range(m - 1, -1, -1):
            B.append(ord(num2[i]) - ord('0'))
        C = [0 for _ in range(n + m)]
        for i in range(n):
            for j in range(m):
                C[i + j] += A[i] * B[j]
        t = 0
        for i in range(len(C)):
            t += C[i]
            C[i] = t % 10
            t //= 10

        # 处理输出
        k = len(C) - 1
        while k > 0 and C[k] == 0:
            k -= 1
        res = ""
        while k >= 0:
            res += str(C[k])
            k -= 1
        return res


if __name__ == "__main__":
    print(Solution().multiply("2", "3"))  # 6
    print(Solution().multiply("123", "456"))  # 56088
