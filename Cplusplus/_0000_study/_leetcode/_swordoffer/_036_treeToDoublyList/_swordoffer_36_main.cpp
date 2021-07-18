// Created by WXX on 2021/7/18 10:24
#include <iostream>

using namespace std;

class Node {
public:
    int val;
    Node *left;
    Node *right;

    Node() {}

    Node(int _val) {
        val = _val;
        left = NULL;
        right = NULL;
    }

    Node(int _val, Node *_left, Node *_right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了47.12%的用户
 * 内存消耗：7.7 MB, 在所有 C++ 提交中击败了10.99%的用户
 */
#define x first
#define y second

class Solution {
public:
    Node *treeToDoublyList(Node *root) {
        if (!root) return root;
        auto ranges = dfs(root);  // 返回以root为根的区间的左右端点
        ranges.x->left = ranges.y;
        ranges.y->right = ranges.x;
        return ranges.x;
    }

    pair<Node *, Node *> dfs(Node *root) {
        if (!root->left && !root->right) return {root, root};
        if (root->left && root->right) {
            auto lranges = dfs(root->left), rranges = dfs(root->right);
            lranges.y->right = root, root->left = lranges.y;
            rranges.x->left = root, root->right = rranges.x;
            return {lranges.x, rranges.y};
        }
        if (root->left) {  // 左子树不空，右子树为空
            auto lranges = dfs(root->left);
            lranges.y->right = root, root->left = lranges.y;
            return {lranges.x, root};
        }
        if (root->right) {  // 左子树为空，右子树不空
            auto rranges = dfs(root->right);
            rranges.x->left = root, root->right = rranges.x;
            return {root, rranges.y};
        }
        return {NULL, NULL};  // 不可能被执行到
    }
};
