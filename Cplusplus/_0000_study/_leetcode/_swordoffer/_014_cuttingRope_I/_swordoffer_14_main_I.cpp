// Created by WXX on 2021/7/18 15:45
#include <iostream>

using namespace std;

class Solution {
public:
    int cuttingRope(int n) {
        if (n <= 3) return 1 * (n - 1);
        int p = 1;
        while (n >= 5) n -= 3, p *= 3;
        return n * p;
    }
};

int main() {

    cout << Solution().cuttingRope(2) << endl;  // 1
    cout << Solution().cuttingRope(10) << endl;  // 36

    return 0;
}
