# coding=utf-8
# Date: 2021/7/16 21:26
from MyTree import *


# 执行用时：48 ms, 在所有 Python3 提交中击败了84.54%的用户
# 内存消耗：16.7 MB, 在所有 Python3 提交中击败了81.80%的用户
class Solution:
    def __init__(self):
        self.ans = 0

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.dfs(root)
        return self.ans

    def dfs(self, root):
        if root is None:
            return 0
        l, r = self.dfs(root.left), self.dfs(root.right)
        self.ans = max(self.ans, l + r)
        return max(l, r) + 1


if __name__ == "__main__":
    nu = None
    nums = [
        1,
        2, 3,
        4, 5
    ]
    root = MyTree(nums).getRoot()
    print(Solution().diameterOfBinaryTree(root))  # 3
