#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 100010;

int p[N];

int find(int x) {
    if (x != p[x]) p[x] = find(p[x]);
    return p[x];
}

/**
 * 执行用时：320 ms, 在所有 C++ 提交中击败了69.20%的用户
 * 内存消耗：43.5 MB, 在所有 C++ 提交中击败了42.91%的用户
 */
class Solution {
public:
    string smallestStringWithSwaps(string s, vector<vector<int>> &pairs) {

        int n = s.size();

        for (int i = 0; i < n; i++) p[i] = i;
        for (auto pair : pairs) p[find(pair[0])] = find(pair[1]);

        vector<vector<char>> t(n);
        // 将同一个并查集的顶点放在一起
        for (int i = 0; i < n; i++) t[find(i)].push_back(s[i]);
        // 集合中元素降序排列
        for (int i = 0; i < n; i++) sort(t[i].rbegin(), t[i].rend());
        // 获得结果
        string res;
        for (int i = 0; i < n; i++) {
            res += t[p[i]].back();
            t[p[i]].pop_back();
        }

        return res;
    }
};

int main() {

    string s = "dcab";
    vector<vector<int>> pairs = {{0, 3},
                                 {1, 2},
                                 {0, 2}};
    cout << Solution().smallestStringWithSwaps(s, pairs) << endl;

    return 0;
}