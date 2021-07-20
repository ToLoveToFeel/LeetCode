// Created by WXX on 2021/7/20 16:33
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了46.17%的用户
 */
class Solution {
public:
    vector<double> dicesProbability(int n) {
        vector<vector<int>> f(n + 1,vector<int>(6 * n + 1));
        f[0][0] = 1;
        for (int i = 1; i <= n; i++)  // 枚举筛子数目
            for (int j = i; j <= 6 * i; j++)  // 枚举点数和
                for (int k = 1; k <= min(j, 6); k++)  // 枚举最后一枚筛子点数
                    f[i][j] += f[i - 1][j - k];

        vector<double> res;
        for (int i = n; i <= 6 * n; i++) res.push_back(f[n][i]);
        int sum = 0;
        for (auto x : res) sum += x;
        for (auto &x : res) x /= sum;
        return res;
    }
};

void OutputBasicArray1D(vector<double> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    OutputBasicArray1D(Solution().dicesProbability(2));

    return 0;
}
