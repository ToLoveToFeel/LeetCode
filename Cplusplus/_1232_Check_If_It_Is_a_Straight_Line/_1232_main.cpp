#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：9.9 MB, 在所有 C++ 提交中击败了98.46%的用户
 */
class Solution {
public:
    bool checkStraightLine(vector<vector<int>> &c) {

        if (c.size() == 0) return true;

        if (c[0][0] == c[1][0]) {  // 说明是垂直于x轴
            for (int i = 2; i < c.size(); i++)
                if (c[i][0] != c[0][0])
                    return false;
        } else {
            int x1 = c[0][0], y1 = c[0][1], x2 = c[1][0], y2 = c[1][1];
            // 两点式
            for (int i = 2; i < c.size(); i++) {
                if ((x1 - x2) * (c[i][1] - y2) != (y1 - y2) * (c[i][0] - x2))
                    return false;
            }
        }

        return true;
    }
};

int main() {

//    vector<vector<int>> c = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};  // true
    vector<vector<int>> c = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}};  // false
    cout << Solution().checkStraightLine(c) << endl;

    return 0;
}