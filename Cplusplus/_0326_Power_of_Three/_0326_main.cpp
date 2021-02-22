// Created by WXX on 2021/2/22 22:12
#include <iostream>

using namespace std;

class Solution {
public:
    bool isPowerOfThree(int n) {

        // int范围内最大的3的幂为：3^19 = 1162261467
        return n > 0 && 1162261467 % n == 0;
    }
};

int main() {

    cout << Solution().isPowerOfThree(0) << endl;  // false
    cout << Solution().isPowerOfThree(27) << endl;  // true

    return 0;
}
