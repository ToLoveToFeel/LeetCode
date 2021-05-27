// Created by WXX on 2021/5/27 8:59
#include <iostream>

using namespace std;

class Solution {
public:
    int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 30; i >= 0; i--)
            if ((x >> i & 1) ^ (y >> i & 1))
                res++;
        return res;
    }
};

int main() {

    cout << Solution().hammingDistance(1, 4) << endl;  // 2

    return 0;
}
