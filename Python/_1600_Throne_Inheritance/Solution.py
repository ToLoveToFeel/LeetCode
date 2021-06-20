# coding=utf-8
# Date: 2021/6/20 10:52
from typing import List


# 执行用时：504 ms, 在所有 Python3 提交中击败了87.50%的用户
# 内存消耗：64.1 MB, 在所有 Python3 提交中击败了67.86%的用户
class ThroneInheritance:

    def __init__(self, kingName: str):
        self.edges = {}
        self.dead = set()
        self.king = kingName

    def birth(self, p: str, c: str) -> None:
        if p in self.edges:
            self.edges[p].append(c)
        else:
            self.edges[p] = [c]

    def death(self, name: str) -> None:
        self.dead.add(name)

    def getInheritanceOrder(self) -> List[str]:
        ans = []
        self.preorder(ans, self.king)
        return ans

    def preorder(self, ans, name):
        if name not in self.dead:
            ans.append(name)
        if name in self.edges:
            for c in self.edges[name]:
                self.preorder(ans, c)


if __name__ == "__main__":
    t = ThroneInheritance("king")
    t.birth("king", "andy")
    t.birth("king", "bob")
    t.birth("king", "catherine")
    t.birth("andy", "matthew")
    t.birth("bob", "alex")
    t.birth("bob", "asha")
    print(t.getInheritanceOrder())  # ['king', 'andy', 'matthew', 'bob', 'alex', 'asha', 'catherine']
    t.death("bob")
    print(t.getInheritanceOrder())  # ['king', 'andy', 'matthew', 'alex', 'asha', 'catherine']
