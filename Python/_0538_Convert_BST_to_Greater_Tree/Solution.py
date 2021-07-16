# coding=utf-8
# Date: 2021/7/16 16:57
from MyTree import *


# 执行用时：84 ms, 在所有 Python3 提交中击败了24.67%的用户
# 内存消耗：17.1 MB, 在所有 Python3 提交中击败了51.92%的用户
class Solution:
    def __init__(self):
        self.sum = 0

    def convertBST(self, root: TreeNode) -> TreeNode:
        self.dfs(root)
        return root

    def dfs(self, root):
        if root is not None:
            self.dfs(root.right)

            self.sum += root.val
            root.val = self.sum

            self.dfs(root.left)


if __name__ == "__main__":
    nu = None
    nums = [
        5,
        3, 13,
        nu, 4, 7, 16
    ]
    root = MyTree(nums).getRoot()
    Solution().convertBST(root)
    print(MyTree().levelOrder(root))  # [[41], [48, 29], [45, 36, 16]]
