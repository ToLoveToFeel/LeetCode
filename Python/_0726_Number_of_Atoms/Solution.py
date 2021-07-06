# coding=utf-8
# Date: 2021/7/5 10:43
from sortedcontainers import SortedDict


# 执行用时：56 ms, 在所有 Python3 提交中击败了5.23%的用户
# 内存消耗：15.6 MB, 在所有 Python3 提交中击败了5.23%的用户
class Solution:
    def __init__(self):
        self.u = 0

    def countOfAtoms(self, formula: str) -> str:
        t = self.dfs(formula)
        res = ""
        for k, v in t.items():
            res += k
            if v > 1:
                res += str(v)
        return res

    def dfs(self, s):
        res = SortedDict()
        while self.u < len(s):
            if s[self.u] == '(':
                self.u += 1
                t = self.dfs(s)
                self.u += 1
                cnt, k = 1, self.u
                while k < len(s) and '0' <= s[k] <= '9':
                    k += 1
                if k > self.u:
                    cnt = (int)(s[self.u:k])
                    self.u = k
                for k, v in t.items():
                    if k not in res:
                        res[k] = 0
                    res[k] += v * cnt
            elif s[self.u] == ')':
                break
            else:
                k = self.u + 1
                while k < len(s) and 'a' <= s[k] <= 'z':
                    k += 1
                key = s[self.u:k]
                self.u = k
                cnt = 1
                while k < len(s) and '0' <= s[k] <= '9':
                    k += 1
                if k > self.u:
                    cnt = int(s[self.u:k])
                    self.u = k
                if key not in res:
                    res[key] = 0
                res[key] += cnt
        return res


if __name__ == "__main__":
    print(Solution().countOfAtoms("H2O"))  # H2O
    print(Solution().countOfAtoms("Mg(OH)2"))  # H2MgO2
    print(Solution().countOfAtoms("K4(ON(SO3)2)2"))  # K4N2O14S4
