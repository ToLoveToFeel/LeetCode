# coding=utf-8
# Date: 2021/7/28 9:37
from MyTree import *


# 执行用时：28 ms, 在所有 Python3 提交中击败了99.72%的用户
# 内存消耗：15.2 MB, 在所有 Python3 提交中击败了74.51%的用户
class Solution:
    def __init__(self):
        self.g = {}
        self.ans = []

    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        self.dfs1(root)
        self.dfs2(target, None, k)
        return self.ans

    def dfs1(self, root):
        if root not in self.g:
            self.g[root] = []

        if root.left is not None:
            if root.left not in self.g:
                self.g[root.left] = []
            self.g[root].append(root.left)
            self.g[root.left].append(root)
            self.dfs1(root.left)
        if root.right is not None:
            if root.right not in self.g:
                self.g[root.right] = []
            self.g[root].append(root.right)
            self.g[root.right].append(root)
            self.dfs1(root.right)

    def dfs2(self, root, father, k):
        if k == 0:
            self.ans.append(root.val)
        else:
            for son in self.g[root]:
                if son is not None and son != father:
                    self.dfs2(son, root, k - 1)


if __name__ == "__main__":
    nu = None
    nums = [
        3,
        5, 1,
        6, 2, 0, 8,
        nu, nu, 7, 4
    ]
    root = MyTree(nums).getRoot()
    target = root.left
    print(Solution().distanceK(root, target, 2))  # [1, 7, 4]
