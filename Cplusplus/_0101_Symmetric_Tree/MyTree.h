#ifndef CPLUSPLUS_MYTREE_H
#define CPLUSPLUS_MYTREE_H

#include <cstring>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class MyTree {

private:
    TreeNode *root;  // 二叉树的根
    int treeSize;  // 二叉树节点个数

public:
    MyTree() {
        root = NULL;
        treeSize = 0;
    }

    // 根据层次遍历创建二叉树
    MyTree(vector<int> nums) {

        if (nums.size() == 0 || nums[0] == INT_MAX)
            return;
        root = new TreeNode(nums[0]);
        treeSize++;
        createByLevelOrder(root, nums, 0);
    }

    int size() {
        return treeSize;
    }

    bool isEmpty() {
        return treeSize == 0;
    }

    TreeNode *getRoot() {
        return root;
    }

    // 层次遍历
    vector<vector<int>> levelOrder() {
        return levelOrder(root);
    }

    static vector<vector<int>> levelOrder(TreeNode *root) {
        vector<vector<int>> res;
        if (root == NULL) return res;

        queue<TreeNode *> q;
        q.push(root);
        int levelNum = 1;  // 当前层的节点数

        while (q.size()) {
            int newLevelNum = 0;
            vector<int> level;
            for (int i = 0; i < levelNum; i++) {  // 遍历当前层的所有节点
                TreeNode *node = q.front();
                q.pop();
                level.push_back(node->val);
                if (node->left != NULL) {
                    q.push(node->left);
                    newLevelNum++;
                }
                if (node->right != NULL) {
                    q.push(node->right);
                    newLevelNum++;
                }
            }
            res.push_back(level);
            levelNum = newLevelNum;
        }
        return res;
    }

    // 前中后序遍历时空复杂度都一样
    // 时间复杂度：O(n)，n为节点数目
    // 空间复杂度：O(h)，h为二叉树高度
    // 前序遍历：递归算法
    vector<int> preorderTraversal() {
        vector<int> res;
        preorderTraversal(root, res);
        return res;
    }

    // 中序遍历：递归算法
    vector<int> inorderTraversal() {
        vector<int> res;
        inorderTraversal(root, res);
        return res;
    }

    // 后序遍历：递归算法
    vector<int> postorderTraversal() {
        vector<int> res;
        postorderTraversal(root, res);
        return res;
    }

private:

    // 创建以node为根节点的二叉树，index代表当前节点node.val的值为nums[index]
    // 只有nums[index] != INT_MAX 才能进入该函数
    void createByLevelOrder(TreeNode *node, vector<int> nums, int index) {
        // INT_MAX 代表该节点为 NULL
        int n = nums.size();
        if (index >= n) return;

        // 0 1 2
        int leftIndex = 2 * index + 1;  // nums[index]对应二叉树节点的左孩子下标为 2 * index + 1
        if (leftIndex <= n - 1) {  // 说明 num[leftIndex] 存在
            if (nums[leftIndex] != INT_MAX) {
                node->left = new TreeNode(nums[leftIndex]);
                treeSize++;
                createByLevelOrder(node->left, nums, leftIndex);
            }
            int rightIndex = leftIndex + 1;  // nums[index]对应二叉树节点的右孩子下标为 2 * index + 2
            if (rightIndex <= n - 1) {  // 说明 num[rightIndex] 存在
                if (nums[rightIndex] != INT_MAX) {
                    node->right = new TreeNode(nums[rightIndex]);
                    treeSize++;
                    createByLevelOrder(node->right, nums, rightIndex);
                }
            }
        }
    }

    void preorderTraversal(TreeNode *node, vector<int> list) {
        if (node != NULL) {
            list.push_back(node->val);
            postorderTraversal(node->left, list);
            postorderTraversal(node->right, list);
        }
    }

    void inorderTraversal(TreeNode *node, vector<int> list) {
        if (node != NULL) {
            postorderTraversal(node->left, list);
            list.push_back(node->val);
            postorderTraversal(node->right, list);
        }
    }

    void postorderTraversal(TreeNode *node, vector<int> list) {
        if (node != NULL) {
            postorderTraversal(node->left, list);
            postorderTraversal(node->right, list);
            list.push_back(node->val);
        }
    }
};


#endif //CPLUSPLUS_MYTREE_H
