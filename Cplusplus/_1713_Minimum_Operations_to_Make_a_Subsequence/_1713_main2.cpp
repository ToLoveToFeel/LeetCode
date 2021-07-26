// Created by WXX on 2021/7/26 9:28
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：312 ms, 在所有 C++ 提交中击败了88.68%的用户
 * 内存消耗：106.8 MB, 在所有 C++ 提交中击败了98.11%的用户
 */
class Solution {
public:
    int minOperations(vector<int> &a, vector<int> &b) {

        const int N = 1e5 + 10;

        int n = a.size(), m = b.size();
        unordered_map<int, int> id;  // (a[i], i) 存储a中的元素在a中的位置
        for (int i = 0; i < n; i++) id[a[i]] = i;

        int q[N] = {0};  // q[l]:记录长度为l的上升子序列最小的结尾值
        int res = 0;  // c的LIS, c是b中的每个元素在a中的位置 c.size() = b.size()
        for (int i = 0; i < m; i++) {
            if (id.count(b[i]) == 0) continue;
            int k = id[b[i]];
            // 在q中找到小于k的最大的数的位置
            int l = 0, r = res;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < k) l = mid;
                else r = mid - 1;
            }
            q[r + 1] = k;
            res = max(res, r + 1);
        }
        return n - res;
    }
};

int main() {

    vector<int> a = {5, 1, 3}, b = {9, 4, 2, 3, 4};
    cout << Solution().minOperations(a, b) << endl;  // 2

    return 0;
}
