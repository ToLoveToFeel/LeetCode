# coding=utf-8
# Date: 2021/7/16 22:24
from MyTree import *


# 执行用时：60 ms, 在所有 Python3 提交中击败了94.81%的用户
# 内存消耗：15.4 MB, 在所有 Python3 提交中击败了37.51%的用户
class Solution:
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if t1 is None:
            return t2
        if t2 is None:
            return t1

        t1.val += t2.val

        t1.left = self.mergeTrees(t1.left, t2.left)
        t1.right = self.mergeTrees(t1.right, t2.right)
        return t1


if __name__ == "__main__":
    nu = None
    nums1 = [
        1,
        3, 2,
        5
    ]
    t1 = MyTree(nums1).getRoot()
    nums2 = [
        2,
        1, 3,
        nu, 4, nu, 7
    ]
    t2 = MyTree(nums2).getRoot()

    root = Solution().mergeTrees(t1, t2)
    print(MyTree().levelOrder(root))
