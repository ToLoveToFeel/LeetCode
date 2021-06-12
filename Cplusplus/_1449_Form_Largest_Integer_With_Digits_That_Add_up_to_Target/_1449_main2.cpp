// Created by WXX on 2021/6/12 10:44
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：8 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.8 MB, 在所有 C++ 提交中击败了91.39%的用户
 */
class Solution {
public:
    string largestNumber(vector<int> &cost, int target) {
        int n = cost.size();
        vector<int> f(target + 1, -2e9);
        f[0] = 0;
        for (auto v : cost)
            for (int j = v; j <= target; j++)
                f[j] = max(f[j], f[j - v] + 1);

        if (f[target] < -1e9) return "0";
        string res;
        int j = target;
        for (int i = n; i >= 1; i--) {
            int v = cost[i - 1];
            while (j >= v && f[j] == f[j - v] + 1) {
                res += to_string(i);
                j -= v;
            }
        }
        return res;
    }
};

int main() {

    vector<int> cost = {4, 3, 2, 5, 6, 7, 2, 5, 5};
    cout << Solution().largestNumber(cost, 9) << endl;  // 7772

    return 0;
}
