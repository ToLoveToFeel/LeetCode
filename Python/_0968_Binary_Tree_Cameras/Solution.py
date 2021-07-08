# coding=utf-8
# Date: 2021/7/8 22:16
from MyTree import *


# 执行用时：48 ms, 在所有 Python3 提交中击败了91.95%的用户
# 内存消耗：15.3 MB, 在所有 Python3 提交中击败了30.65%的用户
class Solution:
    def minCameraCover(self, root: TreeNode) -> int:
        f = self.dfs(root)
        return min(f[1], f[2])

    def dfs(self, root):
        if root is None:
            return 0, 0, int(1e8)
        l, r = self.dfs(root.left), self.dfs(root.right)
        return (
            min(l[1], l[2]) + min(r[1], r[2]),
            min(l[2] + min(r[1], r[2]), r[2] + min(l[1], l[2])),
            min(l[0], min(l[1], l[2])) + min(r[0], min(r[1], r[2])) + 1,
        )


if __name__ == "__main__":
    nu = None
    nums = [
        1,
        1, nu,
        1, 1,
    ]
    root = MyTree(nums).getRoot()
    print(Solution().minCameraCover(root))  # 1
