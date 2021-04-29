// Created by WXX on 2021/4/29 8:58
#include <iostream>
#include <queue>
#include <unordered_map>

using namespace std;

class Solution {
public:
    typedef pair<int, int> PII;  // (当前在stones中的下标为p的位置，且上一步跳跃了k步)

    bool canCross(vector<int>& stones) {
        int n = stones.size();

        unordered_map<int, int> hash;
        for (int i = 0; i < n; i++) hash[stones[i]] = i;

        vector<vector<bool>> st(n, vector<bool>(n, false));  // 判重数组
        queue<PII> q;
        q.push({0, 0});
        st[0][0] = true;
        while (q.size()) {
            auto t = q.front(); q.pop();
            int p = t.first, k = t.second;

            if (p == n - 1) return true;

            for (int i = -1; i <= 1; i++) {
                int nk = k + i;
                // 跳的步数nk要大于0，且坐标stones[p] + nk要存在石头
                if (nk <= 0 || !hash.count(stones[p] + nk)) continue;
                int np = hash[stones[p] + nk];
                q.push({np, nk});
                st[np][nk] = true;
            }
        }
        return false;
    }
};

int main() {

    vector<int> stones = {0, 1, 3, 5, 6, 8, 12, 17};
    cout << Solution().canCross(stones) << endl;  // true

    return 0;
}
