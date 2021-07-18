// Created by WXX on 2021/7/18 15:38
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了57.15%的用户
 * 内存消耗：7 MB, 在所有 C++ 提交中击败了15.25%的用户
 */
#define x first
#define y second

class Solution {
public:

    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    int get_single_sum(int x) {
        int res = 0;
        while (x) res += x % 10, x /= 10;
        return res;
    }

    int get_sum(int x, int y) {
        return get_single_sum(x) + get_single_sum(y);
    }

    int movingCount(int m, int n, int k) {

        int res = 0;
        vector<vector<bool>> st(m, vector<bool>(n));

        queue<pair<int, int>> q;
        q.push({0, 0});
        while (q.size()) {
            auto t = q.front();
            q.pop();

            if (get_sum(t.x, t.y) > k || st[t.x][t.y]) continue;
            res++;
            st[t.x][t.y] = true;

            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    q.push({x, y});
                }
            }
        }
        return res;
    }
};

int main() {

    cout << Solution().movingCount(2, 3, 1) << endl;  // 3

    return 0;
}
