// Created by WXX on 2021/2/22 22:34
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long LL;

// 前缀和 + 离散化 + 树状数组(下标从1开始)
class Solution {
public:
    int m;
    vector<int> tr;  // 树状数组
    vector<int> all;  // 待离散化的数据

    int get(LL x) {
        return lower_bound(all.begin(), all.end(), x) - all.begin() + 1;
    }

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int v) {
        for (int i = x; i <= m; i += lowbit(i)) tr[i] += v;
    }

    int query(int x) {
        int res = 0;
        for (int i = x; i; i -= lowbit(i))res += tr[i];
        return res;
    }

    int countRangeSum(vector<int> &nums, int lower, int upper) {

        int n = nums.size();
        vector<LL> s(n + 1);  // 前缀和
        all.push_back(0);
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
            all.push_back(s[i]);
            all.push_back(s[i] - lower);
            all.push_back(s[i] - upper - 1);
        }
        sort(all.begin(), all.end());
        all.erase(unique(all.begin(), all.end()), all.end());
        m = all.size();
        tr.resize(m + 1);

        int res = 0;
        // 为什么有下面这句话：https://www.acwing.com/activity/content/code/content/477194/
        // 相当于考虑分析中的 sj = 0 --> lower <= si <= upper 这种情况
        add(get(0), 1);
        for (int i = 1; i <= n; i++) {
            int t1 = get(s[i] - lower), t2 = query(get(s[i] - upper - 1));
            res += query(get(s[i] - lower)) - query(get(s[i] - upper - 1));
            add(get(s[i]), 1);
        }
        return res;
    }
};

int main() {

    vector<int> nums = {-2, 5, -1};
    cout << Solution().countRangeSum(nums, -2, 2) << endl;  // 3

    return 0;
}
