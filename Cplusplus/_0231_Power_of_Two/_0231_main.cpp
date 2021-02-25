// Created by WXX on 2021/2/25 21:41
#include <iostream>

using namespace std;

// lowbit
class Solution {
public:
    bool isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
};

int main() {

    cout << Solution().isPowerOfTwo(1) << endl;  // true
    cout << Solution().isPowerOfTwo(16) << endl;  // true
    cout << Solution().isPowerOfTwo(218) << endl;  // false

    return 0;
}
