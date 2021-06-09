# coding=utf-8


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


'''
    nu = None
    nums = [
        1,
        2, 2,
        3, nu, 4, 3
    ]
    root = MyTree(nums).getRoot()
'''


class MyTree:
    def __init__(self, nums=[]):
        self.nums = nums
        self.size = 0

        if len(self.nums) == 0 or self.nums[0] == None:
            return
        self.root = TreeNode(self.nums[0])
        self.size += 1
        self._createByLevelOrder(self.root, self.nums, 0)

    def size(self):
        return self.size

    def isEmpty(self):
        return self.size == 0

    def getRoot(self):
        return self.root

    # 层次遍历
    def levelOrder(self, root):
        res = []
        q = []
        if root is not None:
            q.append(root)

        while len(q) > 0:
            level = []
            length = len(q)
            while length > 0:
                t = q[0]
                q.pop(0)
                level.append(t.val)
                if t.left is not None:
                    q.append(t.left)
                if t.right is not None:
                    q.append(t.right)
                length -= 1
            res.append(level)
        return res

    # 前序遍历
    def preorder(self, root):
        res = []
        self._preorder(root, res)
        return res

    # 中序遍历
    def inorder(self, root):
        res = []
        self._inorder(root, res)
        return res

    # 后序遍历
    def postorder(self, root):
        res = []
        self._postorder(root, res)
        return res

    def _createByLevelOrder(self, node, nums, index):
        n = len(nums)
        if index >= n:
            return
        leftIndex = 2 * index + 1
        if leftIndex < n:
            if nums[leftIndex] is not None:
                node.left = TreeNode(nums[leftIndex])
                self.size += 1
                self._createByLevelOrder(node.left, nums, leftIndex)
        rightIndex = leftIndex + 1
        if rightIndex < n:
            if nums[rightIndex] is not None:
                node.right = TreeNode(nums[rightIndex])
                self.size += 1
                self._createByLevelOrder(node.right, nums, rightIndex)

    def _preorder(self, root, res):
        if root is not None:
            res.append(root.val)
            self._preorder(root.left, res)
            self._preorder(root.right, res)

    def _inorder(self, root, res):
        if root is not None:
            self._inorder(root.left, res)
            res.append(root.val)
            self._inorder(root.right, res)

    def _postorder(self, root, res):
        if root is not None:
            self._postorder(root.left, res)
            self._postorder(root.right, res)
            res.append(root.val)

    def __len__(self):
        """返回树中节点数"""
        return self.size

    def __str__(self):  # print该对象使用
        return str(self.levelOrder(self.root))


if __name__ == "__main__":
    nu = None
    nums = [
        1,
        2, 2,
        3, nu, 4, 3
    ]
    root = MyTree(nums).getRoot()
    print(MyTree().levelOrder(root))  # 层次遍历
    print(MyTree().preorder(root))  # 前序遍历
    print(MyTree().inorder(root))  # 中序遍历
    print(MyTree().postorder(root))  # 后序遍历
