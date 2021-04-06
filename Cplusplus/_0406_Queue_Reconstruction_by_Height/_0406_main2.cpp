// Created by WXX on 2021/4/6 15:35
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 具体分析参考：https://blog.csdn.net/weixin_42638946/article/details/114502760?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161769890016780255260256%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=161769890016780255260256&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_v2~rank_v29-1-114502760.nonecase&utm_term=%E6%A0%91%E7%8A%B6
/**
 * 执行用时：104 ms, 在所有 C++ 提交中击败了76.69%的用户
 * 内存消耗：23.9 MB, 在所有 C++ 提交中击败了24.85%的用户
 */
class Solution {
public:
    int n;
    vector<int> tr;

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int c) {
        for (int i = x; i <= n; i += lowbit(i)) tr[i] += c;
    }

    int query(int x) {
        int res = 0;
        for (int i = x; i; i -= lowbit(i)) res += tr[i];
        return res;
    }

    vector<vector<int>> reconstructQueue(vector<vector<int>> &people) {
        n = people.size();
        tr.resize(n + 1);  // 树状数组下标必须从1开始

        sort(people.begin(), people.end(), [](vector<int> a, vector<int> b) {
            if (a[0] != b[0]) return a[0] < b[0];  // 按照第一维升序
            return a[1] > b[1];  // 按照第二维降序
        });

        vector<vector<int>> res(n);
        for (auto p : people) {
            int h = p[0], k = p[1];
            int l = 1, r = n;
            while (l < r) {
                int mid = l + r >> 1;
                // query(mid)返回a[1..mid]中1的个数，0表示该位置没被占用
                if (mid - query(mid) >= k + 1) r = mid;
                else l = mid + 1;
            }
            res[r - 1] = p;  // a[1]表示第0个位置的占用情况
            add(r, 1);
        }
        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<int>> people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    OutputBasicArray2D1(Solution().reconstructQueue(people));

    return 0;
}
