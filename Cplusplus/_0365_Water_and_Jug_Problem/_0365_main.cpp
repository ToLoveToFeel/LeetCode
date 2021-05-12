// Created by WXX on 2021/5/12 20:48
#include <iostream>

using namespace std;

class Solution {
public:
    bool canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        return !z || z % gcd(x, y) == 0;
    }

    int gcd(int a, int b) {
        return b ? gcd(b, a % b) : a;
    }
};

int main() {

    cout << Solution().canMeasureWater(3, 5, 4) << endl;  // true
    cout << Solution().canMeasureWater(2, 6, 5) << endl;  // false

    return 0;
}
