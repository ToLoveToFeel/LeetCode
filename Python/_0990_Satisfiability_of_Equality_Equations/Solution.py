# coding=utf-8
# Date: 2021/6/6 16:12
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了97.54%的用户
# 内存消耗：15 MB, 在所有 Python3 提交中击败了52.46%的用户
class Solution:
    def equationsPossible(self, eq: List[str]) -> bool:
        p = [i for i in range(30)]
        # 第一步：将所有等式对应的字母合并
        for e in eq:
            if e[1:3] == "==":
                a = self.find(p, ord(e[0]) - ord('a'))
                b = self.find(p, ord(e[3]) - ord('a'))
                if a != b:
                    p[a] = b
        # 检查所有的不等式，看是否存在矛盾
        for e in eq:
            if e[1:3] == "!=":
                a = self.find(p, ord(e[0]) - ord('a'))
                b = self.find(p, ord(e[3]) - ord('a'))
                if a == b:
                    return False
        return True

    def find(self, p, x):
        if p[x] != x:
            p[x] = self.find(p, p[x])
        return p[x]


if __name__ == "__main__":
    print(Solution().equationsPossible(["a==b", "b!=a"]))  # False
