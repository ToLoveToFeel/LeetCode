// Created by WXX on 2021/6/1 14:04
#include <iostream>
#include <vector>

using namespace std;

// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;

    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }

    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }

    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了85.85%的用户
 * 内存消耗：16.1 MB, 在所有 C++ 提交中击败了38.68%的用户
 */
class Solution {
public:

    vector<vector<int>> s;

    Node* construct(vector<vector<int>>& grid) {
        int n = grid.size();
        s = vector<vector<int>>(n + 1, vector<int>(n + 1));
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + grid[i - 1][j - 1];
        return dfs(1, 1, n, n);
    }

    Node* dfs(int x1, int y1, int x2, int y2) {
        int n = x2 - x1 + 1;
        int sum = s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
        if (!sum || sum == n * n) return new Node(!!sum, true);  // !!sum 在sum=0时返回0, 在sum!=0时返回1
        auto node = new Node(0, false);
        int m = n / 2;
        node->topLeft = dfs(x1, y1, x1 + m - 1, y1 + m - 1);
        node->topRight = dfs(x1, y1 + m, x1 + m - 1, y2);
        node->bottomLeft = dfs(x1 + m, y1, x2, y1 + m - 1);
        node->bottomRight = dfs(x1 + m, y1 + m, x2, y2);
        return node;
    }
};


int main() {


    return 0;
}
