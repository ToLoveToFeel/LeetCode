# coding=utf-8
# Date: 2021/5/21 20:48
from typing import List


# 执行用时：272 ms, 在所有 Python3 提交中击败了71.38%的用户
# 内存消耗：15.9 MB, 在所有 Python3 提交中击败了5.00%的用户
MOD = int(pow(2, 64))
class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        P = 131
        n = len(s); m = len(words); w = len(words[0])
        # 字符串哈希
        h = [0 for _ in range(n + 5)]; p = [1 for _ in range(n + 5)]
        for i in range(1, n + 1):
            h[i] = (h[i - 1] * P + ord(s[i - 1])) % MOD
            p[i] = (p[i - 1] * P) % MOD
        # 统计words中每个单词出现的次数
        tot = {}
        for word in words:
            t = 0
            for c in word:
                t = (t * P + ord(c)) % MOD
            if t not in tot:
                tot[t] = 1
            else:
                tot[t] += 1
        # 使用滑动窗口求结果
        res = []
        for i in range(w):
            wd = {}
            cnt = 0
            for j in range(i, n - (w - 1), w):
                # 滑窗为[j-m*w, j)
                # 每次滑入[j, j+w-1], 滑出[j-m*w, j-m*w+w-1]
                if j >= i + m * w:
                    hash = self.get(h, p, j - m * w + 1, j - m * w + w)
                    wd[hash] -= 1
                    if hash in tot and wd[hash] < tot[hash]:
                        cnt -= 1
                hash = self.get(h, p, j + 1, j + w)
                if hash not in wd:
                    wd[hash] = 1
                else:
                    wd[hash] += 1
                if hash in tot and wd[hash] <= tot[hash]:
                    cnt += 1
                if cnt == m:
                    res.append(j - (m - 1) * w)
        return res

    def get(self, h, p, l, r):
        return (h[r] - h[l - 1] * p[r - l + 1]) % MOD


if __name__ == "__main__":
    s = "barfoothefoobarman"
    words = ["foo", "bar"]
    print(Solution().findSubstring(s, words))
