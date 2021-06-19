// Created by WXX on 2021/6/19 9:43
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了95.80%的用户
 * 内存消耗：7.8 MB, 在所有 C++ 提交中击败了83.70%的用户
 */
class Solution {
public:
    vector<int> state;
    vector<bool> st;  // st[i]=true说明arr[i]自身有重复元素
    int res;

    int maxLength(vector<string> &arr) {
        int n = arr.size();
        state.resize(n);
        st = vector<bool>(n);
        for (int i = 0; i < n; i++) {
            for (auto c : arr[i]) {
                int bit = 1 << (c - 'a');
                if ((state[i] & bit) != 0) {
                    st[i] = true;
                    break;
                }
                state[i] |= bit;
            }
        }
        dfs(arr, 0, 0, 0);
        return res;
    }

    // U: 考察到arr[u], cnt: 目前结果长度, t: 二进制，表示选了哪些字母
    void dfs(vector<string> &arr, int u, int cnt, int t) {
        if (u == arr.size()) {
            res = max(res, cnt);
            return;
        }
        dfs(arr, u + 1, cnt, t);  // 不选arr[u]
        if ((t & state[u]) == 0 && !st[u]) {
            dfs(arr, u + 1, cnt + arr[u].size(), t | state[u]);  // 选arr[u]
        }
    }
};

int main() {

    vector<string> arr = {"un", "iq", "ue"};
    cout << Solution().maxLength(arr) << endl;  // 4

    return 0;
}
