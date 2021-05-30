// Created by WXX on 2021/5/30 9:43
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了35.03%的用户
 * 内存消耗：11.7 MB, 在所有 C++ 提交中击败了42.08%的用户
 */
class Solution {
public:
    vector<int> res;

    vector<int> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return res;
    }

    void dfs(int cur, int n) {
        if (cur <= n) res.push_back(cur);
        else return;
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, n);
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    OutputBasicArray1D(Solution().lexicalOrder(13));

    return 0;
}
