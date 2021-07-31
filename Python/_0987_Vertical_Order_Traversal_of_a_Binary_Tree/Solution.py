# coding=utf-8
# Date: 2021/7/31 15:21
from MyTree import *


# 执行用时：32 ms, 在所有 Python3 提交中击败了96.10%的用户
# 内存消耗：15.5 MB, 在所有 Python3 提交中击败了5.32%的用户
class Solution:
    def __init__(self):
        from sortedcontainers import SortedDict
        self.S = SortedDict()

    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        self.dfs(root, 0, 0)

        res = []
        for v in self.S.values():
            v.sort()
            col = []
            for p in v:
                col.append(p[1])
            res.append(col)
        return res

    def dfs(self, root, x, y):
        if root is None:
            return

        if y not in self.S:
            self.S[y] = []
        self.S[y].append([x, root.val])

        self.dfs(root.left, x + 1, y - 1)
        self.dfs(root.right, x + 1, y + 1)


if __name__ == "__main__":
    nu = None
    nums = [
        3,
        9, 20,
        nu, nu, 15, 7
    ]
    root = MyTree(nums).getRoot()
    print(Solution().verticalTraversal(root))  # [[9], [3, 15], [20], [7]]
