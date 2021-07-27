# coding=utf-8
# Date: 2021/7/27 9:19
from MyTree import *


# 执行用时：28 ms, 在所有 Python3 提交中击败了95.70%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了42.58%的用户
class Solution:
    def __init__(self):
        self.d1, self.d2 = int(1e18), int(1e18)

    def findSecondMinimumValue(self, root: TreeNode) -> int:
        self.dfs(root)
        if self.d2 == int(1e18):
            self.d2 = -1
        return self.d2

    def dfs(self, root):
        if root is None:
            return
        x = root.val
        if x < self.d1:
            self.d2 = self.d1
            self.d1 = x
        elif self.d1 < x < self.d2:
            self.d2 = x
        self.dfs(root.left)
        self.dfs(root.right)


if __name__ == "__main__":
    nu = None
    nums = [
        2,
        2, 5,
        nu, nu, 5, 7
    ]
    root = MyTree(nums).getRoot()
    print(Solution().findSecondMinimumValue(root))  # 5
