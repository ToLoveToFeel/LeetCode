// Created by WXX on 2021/7/20 16:33
#include <iostream>
#include <vector>

using namespace std;

// TLE: n=11时
class Solution {
public:
    vector<vector<int>> f;  // 记忆化搜索使用

    vector<double> dicesProbability(int n) {
        f = vector<vector<int>>(n + 1,vector<int>(6 * n + 1));

        vector<double> res;
        for (int i = n; i <= 6 * n; i++) res.push_back(dfs(n, i) * 1.0);
        int sum = 0;
        for (auto x : res) sum += x;
        for (auto &x : res) x /= sum;
        return res;
    }

    // 返回投掷n次筛子和为s的方案数
    int dfs(int n, int s) {
        if (s < 0) return 0;
        if (!n) return !s;  // 如果最后s减到0算一种做法，没有减到0(说明掷出的点数总和不是s)就不加1

        if (f[n][s]) return f[n][s];
        int res = 0;
        for (int i = 1; i <= 6; i++)
            res += dfs(n - 1, s - i);
        f[n][s] = res;
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
