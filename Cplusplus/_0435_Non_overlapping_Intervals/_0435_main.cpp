// Created by WXX on 2021/6/1 20:48
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：96 ms, 在所有 C++ 提交中击败了37.26%的用户
 * 内存消耗：24 MB, 在所有 C++ 提交中击败了6.74%的用户
 */
class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>> &q) {
        sort(q.begin(), q.end(), [](vector<int> a, vector<int> b) {
            return a[1] < b[1];
        });
        if (q.empty()) return 0;
        int res = 1, r = q[0][1];
        for (int i = 1; i < q.size(); i++)
            if (q[i][0] >= r) {
                res++;
                r = q[i][1];
            }
        return q.size() - res;
    }
};

int main() {


    return 0;
}
