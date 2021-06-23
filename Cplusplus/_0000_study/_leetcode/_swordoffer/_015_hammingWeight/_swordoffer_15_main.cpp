// Created by WXX on 2021/6/23 8:55
#include <iostream>

using namespace std;

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) res += (n >> i & 1);
        return res;
    }
};

int main() {

    cout << Solution().hammingWeight(13) << endl;
    cout << Solution().hammingWeight(0b11111111111111111111111111111101) << endl;

    return 0;
}
