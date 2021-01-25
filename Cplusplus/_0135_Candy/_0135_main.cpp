// Created by WXX on 2021/1/25 23:23
#include <iostream>
#include <vector>

using namespace std;

// 记忆化搜索
/**
 * 执行用时：32 ms, 在所有 C++ 提交中击败了94.20%的用户
 * 内存消耗：18.9 MB, 在所有 C++ 提交中击败了5.02%的用户
 */
class Solution {
public:
    vector<int> f;
    vector<int> w;
    int n;

    int candy(vector<int> &ratings) {

        n = ratings.size();
        w = ratings;
        f.resize(n, -1);

        int res = 0;
        for (int i = 0; i < n; i++) res += dp(i);
        return res;
    }

    // 返回小朋友x需要的最少糖果
    int dp(int x) {
        if (f[x] != -1) return f[x];
        f[x] = 1;
        if (x && w[x - 1] < w[x]) f[x] = max(f[x], dp(x - 1) + 1);
        if (x + 1 < n && w[x + 1] < w[x]) f[x] = max(f[x], dp(x + 1) + 1);
        return f[x];
    }
};

int main() {

    vector<int> ratings = {1, 0, 2};
    cout << Solution().candy(ratings) << endl;  // 5

    return 0;
}
