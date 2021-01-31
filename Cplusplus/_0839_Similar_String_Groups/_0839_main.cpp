// Created by WXX on 2021/1/31 10:16
#include <iostream>
#include <vector>

using namespace std;

const int N = 10010;  // 本题给的数据标注的长度是错误的，这句话错误：1 <= strs.length <= 100

int p[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：9.6 MB, 在所有 C++ 提交中击败了98.78%的用户
 */
class Solution {
public:
    int numSimilarGroups(vector<string> &strs) {

        int n = strs.size();
        cout << n << endl;
        for (int i = 0; i < n; i++) p[i] = i;  // 并查集初始化
        int res = n;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int p1 = find(i), p2 = find(j);
                if (p1 != p2 && is_similar(strs[i], strs[j])) {
                    p[p1] = p2;
                    res--;
                }
            }
        return res;
    }

    bool is_similar(string &a, string &b) {
        int cnt = 0;
        for (int i = 0; i < a.size(); i++)
            if (a[i] != b[i]) {
                cnt++;
                if (cnt > 2) return false;
            }
        return true;
    }
};

int main() {

//    vector<string> strs = {"tars", "rats", "arts", "star"};  // 2
    vector<string> strs = {"omv", "ovm"};  // 1
    cout << Solution().numSimilarGroups(strs) << endl;

    return 0;
}
