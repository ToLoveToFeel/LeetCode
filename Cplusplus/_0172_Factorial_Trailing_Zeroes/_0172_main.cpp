// Created by WXX on 2021/6/29 14:32
#include <iostream>

using namespace std;

class Solution {
public:
    int trailingZeroes(int n) {
        int res = 0;
        while (n) res += n / 5, n /= 5;
        return res;
    }
};

int main() {

    cout << Solution().trailingZeroes(3) << endl;  // 0
    cout << Solution().trailingZeroes(5) << endl;  // 1

    return 0;
}
