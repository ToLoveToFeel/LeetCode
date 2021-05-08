// Created by WXX on 2021/5/8 9:11
#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

class Solution {
public:

    vector<int> jobs;
    int k;

    int minimumTimeRequired(vector<int>& _jobs, int _k) {

        jobs = _jobs;
        k = _k;

        sort(jobs.begin(), jobs.end(), greater<int>());  // 优化搜索顺序
        int l = jobs[0], r = accumulate(jobs.begin(), jobs.end(), 0);
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    bool check(int mid) {
        vector<int> w(k, 0);
        return dfs(w, 0, mid);
    }

    // 当前遍历到jobs[u], 工作量限制不超过mid
    bool dfs(vector<int> &w, int u, int mid) {
        if (u == jobs.size()) return true;

        int t = jobs[u];  // 待分配的工作
        for (auto &a : w) {  // 当前考察的某人的工作量为a
            if (a + t <= mid) {
                a += t;
                if (dfs(w, u + 1, mid)) return true;
                a -= t;
            }
            // 此时说明当前考察的人分配jobs[u]不能得到正确答案，则：
            if (a == 0 || a + t == mid) break;  // 两个剪枝
        }
        return false;
    }
};

int main() {

    vector<int> jobs = {3, 2, 3};
    cout << Solution().minimumTimeRequired(jobs, 3) << endl;  // 3

    return 0;
}
