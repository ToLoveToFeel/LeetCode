// Created by WXX on 2021/6/2 9:45
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：100 ms, 在所有 C++ 提交中击败了55.79%的用户
 * 内存消耗：25.3 MB, 在所有 C++ 提交中击败了66.46%的用户
 */
class Solution {
public:
    vector<int> findRightInterval(vector<vector<int>> &q) {
        int n = q.size();
        for (int i = 0; i < n; i++) q[i].push_back(i);
        sort(q.begin(), q.end());
        vector<int> res(n, -1);
        for (auto &x : q) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (q[mid][0] >= x[1]) r = mid;
                else l = mid + 1;
            }
            if (q[r][0] >= x[1]) res[x[2]] = q[r][2];
        }
        return res;
    }
};

int main() {


    return 0;
}
