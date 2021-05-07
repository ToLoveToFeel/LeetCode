// Created by WXX on 2021/5/7 9:08
#include <iostream>

using namespace std;

class Solution {
public:
    int xorOperation(int n, int start) {
        return (sum(start / 2 - 1) ^ sum(start / 2 + n - 1)) * 2 + (n & start & 1);
    }

    // sum(x)=0^1^2^...^x
    int sum(int x) {
        if (x % 4 == 0) return x;
        if (x % 4 == 1) return 1;
        if (x % 4 == 2) return x + 1;
        return 0;
    }
};

int main() {

    cout << Solution().xorOperation(5, 0) << endl;
    cout << Solution().xorOperation(4, 3) << endl;
    cout << Solution().xorOperation(1, 7) << endl;

    return 0;
}
