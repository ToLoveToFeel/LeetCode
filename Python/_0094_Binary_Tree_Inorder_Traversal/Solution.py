# coding=utf-8
# Date: 2021/6/9 14:07
from MyTree import *


# 执行用时：40 ms, 在所有 Python3 提交中击败了62.33%的用户
# 内存消耗：14.7 MB, 在所有 Python3 提交中击败了84.56%的用户
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res =[]
        stk = []
        while root or len(stk) > 0:
            while root:
                stk.append(root)
                root = root.left
            root = stk[len(stk) - 1]
            stk.pop(len(stk) - 1)
            res.append(root.val)
            root = root.right
        return res


if __name__ == "__main__":
    nu = None
    nums = [
        1,
        nu, 2,
        nu, nu, 3,
    ]
    root = MyTree(nums).getRoot()
    print(Solution().inorderTraversal(root))  # [1, 3, 2]
