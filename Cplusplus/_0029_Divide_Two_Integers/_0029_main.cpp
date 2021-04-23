// Created by WXX on 2021/4/23 10:58
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int divide(int dividend, int divisor) {

        const int HALF_INT_MIN = -1073741824;
        int x = dividend, y = divisor;

        bool sign = (x > 0) ^(y > 0);  // false表示结果为正数
        if (x > 0) x = -x;
        if (y > 0) y = -y;

        // 预处理出二元倍增数组
        vector<pair<int, int>> ys;
        for (int t1 = y, t2 = -1; t1 >= x; t1 += t1, t2 += t2) {
            ys.push_back({t1, t2});
            if (t1 < HALF_INT_MIN) break;  // 此时应该退出，不然会越界
        }

        // 反向遍历这个倍增数组得到答案
        int res = 0;
        for (int i = ys.size() - 1; i >= 0; i--)
            if (x <= ys[i].first) {
                x -= ys[i].first;
                res += ys[i].second;
            }
        if (!sign) {  // 说明结果为正数
            if (res == INT_MIN)
                return INT_MAX;
            res = -res;
        }
        return res;
    }
};

int main() {

    cout << Solution().divide(10, 3) << endl;  // 3
    cout << Solution().divide(7, -3) << endl;  // -2

    return 0;
}
