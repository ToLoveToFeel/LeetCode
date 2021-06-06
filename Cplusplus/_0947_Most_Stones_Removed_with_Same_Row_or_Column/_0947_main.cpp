#include <iostream>
#include <vector>

using namespace std;

const int N = 1010;

int p[N];

int find(int x) {
    if(p[x] != x) p[x] = find(p[x]);
    return p[x];
}

/**
 * 执行用时：244 ms, 在所有 C++ 提交中击败了29.77%的用户
 * 内存消耗：13.7 MB, 在所有 C++ 提交中击败了96.11%的用户
 */
class Solution {
public:
    int removeStones(vector<vector<int>> &stones) {
        int n = stones.size();
        for (int i = 0; i < n; i++) p[i] = i;  // 并查集初始化

        int cnt = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])  {
                    // 第i个石子和第j个石子在一个集合中
                    int p1 = find(i), p2 = find(j);
                    if (p1 != p2) {
                        p[p1] = p2;
                        cnt--;
                    }
                }
        }
        return n - cnt;
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