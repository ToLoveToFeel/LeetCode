// Created by WXX on 2021/7/19 14:25
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.9 MB, 在所有 C++ 提交中击败了29.85%的用户
 */
class Solution {
public:
    bool verifyPostorder(vector<int> &postorder) {
        return dfs(postorder, 0, postorder.size() - 1);
    }

    bool dfs(vector<int> &postorder, int l, int r) {
        if (l >= r) return true;

        int root = postorder[r];
        int k = l;
        while (postorder[k] < root) k++;
        for (int i = k; i < r; i++)
            if (postorder[i] < root)
                return false;

        return dfs(postorder, l, k - 1) && dfs(postorder, k, r - 1);
    }
};

int main() {

    vector<int> postorder = {1, 6, 3, 2, 5};
    cout << Solution().verifyPostorder(postorder) << endl;  // false

    return 0;
}
