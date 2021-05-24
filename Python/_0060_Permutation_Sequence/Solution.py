# coding=utf-8
# Date: 2021/5/24 17:05


class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        fact = [1 for _ in range(n)]
        for i in range(1, n):
            fact[i] = fact[i - 1] * i

        res = ""
        st = [False for _ in range(10)]
        for i in range(n):
            for j in range(1, n + 1):
                if not st[j]:
                    if fact[n - 1 - i] < k:
                        k -= fact[n - 1 - i]
                    else:
                        res += chr(j + ord('0'))
                        st[j] = True
                        break
        return res


if __name__ == "__main__":
    print(Solution().getPermutation(3, 3))  # 213
    print(Solution().getPermutation(4, 9))  # 2314
