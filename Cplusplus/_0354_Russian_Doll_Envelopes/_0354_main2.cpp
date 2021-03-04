// Created by WXX on 2021/3/4 9:22
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// LIS模型
/**
 * 执行用时：48 ms, 在所有 C++ 提交中击败了88.57%的用户
 * 内存消耗：15.9 MB, 在所有 C++ 提交中击败了19.42%的用户
 */
class Solution {
public:
    static bool cmp(vector<int> &a, vector<int> &b) {
        // 按照第一维升序，第二维降序方式排列
        return a[0] == b[0] ? a[1] > b[1] : a[0] < b[0];
    }

    int maxEnvelopes(vector<vector<int>> &w) {

        int n = w.size();
        sort(w.begin(), w.end(), cmp);
        vector<int> q(n + 1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = res;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < w[i][1]) l = mid;
                else r = mid - 1;
            }
            res = max(res, r + 1);
            q[r + 1] = w[i][1];
        }
        return res;
    }
};

int main() {

    vector<vector<int>> w = {{5, 4},
                             {6, 4},
                             {6, 7},
                             {2, 3}};
    cout << Solution().maxEnvelopes(w) << endl;

    return 0;
}
