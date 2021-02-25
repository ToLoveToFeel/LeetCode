// Created by WXX on 2021/2/25 21:27
#include <iostream>
#include <cmath>

using namespace std;

class Solution {
public:
    bool isPowerOfFour(int n) {

        if (n <= 0) return false;
        int r = sqrt(n);
        if (r * r != n) return false;
        return (1 << 30) % n == 0;
    }
};

int main() {

    cout << Solution().isPowerOfFour(16) << endl;  // true
    cout << Solution().isPowerOfFour(5) << endl;  // false
    cout << Solution().isPowerOfFour(1) << endl;  // true

    return 0;
}
