#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

const int N = 1010;

int p[N], sz[N];

int find(int x) {
    if(p[x] != x) p[x] = find(p[x]);
    return p[x];
}

/**
* 执行用时：236 ms, 在所有 C++ 提交中击败了41.21%的用户
 * 内存消耗：14.6 MB, 在所有 C++ 提交中击败了58.08%的用户
*/
class Solution {
public:
    int removeStones(vector<vector<int>> &stones) {

        int n = stones.size();
        for (int i = 0; i < n; i++) p[i] = i, sz[i] = 1;  // 并查集初始化
        // 考虑任意两个石子之间
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])  {
                    // 第i个石子和第j个石子在一个集合中
                    int p1 = find(i), p2 = find(j);
                    if (p1 != p2) {
                        p[p1] = p2;
                        sz[p2] += sz[p1];
                    }
                }
        }

        int res = 0;
        unordered_set<int> groups;  // 防止重复计算
        for (int i = 0; i < n; i++) {
            int t = find(i);
            if (!groups.count(t)) {
                res += sz[t] - 1;
                groups.insert(t);
            }
        }

        return res;
    }
};


int main() {

    vector<vector<int>> stones1 = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};  // 5
    cout << Solution().removeStones(stones1) << endl;

    vector<vector<int>> stones2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};  // 3
    cout << Solution().removeStones(stones2) << endl;

    vector<vector<int>> stones3 = {{0, 0}};  // 0
    cout << Solution().removeStones(stones3) << endl;

    return 0;
}