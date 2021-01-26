// Created by WXX on 2021/1/26 17:16
#include <iostream>

using namespace std;

// 从高位到低位找到m和n第一个不同的位，结果从该位开始都是0
class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {

        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if ((m >> i & 1) != (n >> i & 1)) break;
            if (m >> i & 1) res += 1 << i;
        }
        return res;
    }
};

int main() {

    cout << Solution().rangeBitwiseAnd(5, 7) << endl;  // 4

    return 0;
}
