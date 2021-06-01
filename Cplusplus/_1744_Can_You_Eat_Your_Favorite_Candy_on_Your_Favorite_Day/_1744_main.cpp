// Created by WXX on 2021/6/1 10:14
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：464 ms, 在所有 C++ 提交中击败了30.95%的用户
 * 内存消耗：127.1 MB, 在所有 C++ 提交中击败了10.31%的用户
 */
class Solution {
public:
    typedef long long LL;

    vector<bool> canEat(vector<int> &candiesCount, vector<vector<int>> &queries) {
        int n = candiesCount.size();
        vector<LL> s(n + 1);
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + candiesCount[i - 1];
        vector<bool> res;
        for (auto q : queries) {
            int type = q[0], day = q[1], cap = q[2];
            LL x1 = day + 1, y1 = (LL) (day + 1) * cap;  // 在给定条件下可以吃到的糖果范围为[x1, y1]
            LL x2 = s[type] + 1, y2 = s[type + 1];  // type类型的糖果的范围是[x2, y2]
            res.push_back(!(x1 > y2 || x2 > y1));  // 有交集说明能吃到该类糖果
        }
        return res;
    }
};

void OutputBasicArray1D(vector<bool> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (nums[i]) cout << "true";
        else cout << "false";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<int> candiesCount = {
            7, 4, 5, 3, 8
    };
    vector<vector<int>> queries = {
            {0, 2, 2},
            {4, 2, 4},
            {2, 3, 1000000000},
    };
    OutputBasicArray1D(Solution().canEat(candiesCount, queries));

    return 0;
}
