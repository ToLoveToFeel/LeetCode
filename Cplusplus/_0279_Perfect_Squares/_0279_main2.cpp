// Created by WXX on 2021/1/29 21:52
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// 数学做法
/**
 * 根据拉格朗日四平方和定理，可知答案必定为1,2,3,4中的一个
 * 其次根据勒让德三平方和定理，可知：
 *      n能表示成三个整数的平方和 可知 n!=(4^a)*(8b+7)
 *      n!=(4^a)*(8b+7) 可知 n能表示成三个整数的平方和，也可能是2个或者4个
 */
class Solution {
public:

    bool check(int x) {
        int r = sqrt(x);
        return r * r == x;
    }

    int numSquares(int n) {

        if (check(n)) return 1;

        for (int a = 1; a <= n / a; a++)
            if (check(n - a * a))
                return 2;

        while (n % 4 == 0) n /= 4;
        if (n % 8 != 7) return 3;

        return 4;
    }
};

int main() {

    cout << Solution().numSquares(12) << endl;  // 3
    cout << Solution().numSquares(13) << endl;  // 2

    return 0;
}