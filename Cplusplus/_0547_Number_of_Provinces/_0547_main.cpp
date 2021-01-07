#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：48 ms, 在所有 C++ 提交中击败了97.54%的用户
 * 内存消耗：13.9 MB, 在所有 C++ 提交中击败了27.12%的用户
 */
class Solution {
public:

    static const int N = 210;

    int p[N];

    int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    int findCircleNum(vector<vector<int>> &isConnected) {

        for (int i = 0; i < N; i++) p[i] = i;

        int n = isConnected.size();
        int res = n;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int p1 = find(i), p2 = find(j);
                if (isConnected[i][j] == 1 && p1 != p2) {
                    res--;
                    p[p1] = p2;
                }
            }

        return res;
    }
};

int main() {

//    vector<vector<int>> isConnected = {
//            {1, 1, 0},
//            {1, 1, 0},
//            {0, 0, 1}
//    };
    vector<vector<int>> isConnected = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };
    cout << Solution().findCircleNum(isConnected) << endl;  // 2

    return 0;
}
