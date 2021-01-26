// Created by WXX on 2021/1/26 16:32
#include <iostream>

using namespace std;

class Solution {
public:
    uint32_t reverseBits(uint32_t n) {

        uint32_t res = 0;
        for (int i = 0; i < 32; i++)
            res = (res * 2) + (n >> i & 1);
        return res;
    }
};

int main() {

    cout << Solution().reverseBits(43261596) << endl;  // 964176192

    return 0;
}
