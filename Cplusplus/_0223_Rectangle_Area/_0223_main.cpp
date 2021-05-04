// Created by WXX on 2021/5/4 15:21
#include <iostream>
#include <vector>

using namespace std;

typedef long long LL;

class Solution {
public:
    int computeArea(LL A, LL B, LL C, LL D, LL E, LL F, LL G, LL H) {
        int X = max(0ll, min(C, G) - max(A, E));
        int Y = max(0ll, min(D, H) - max(B, F));
        return (C - A) * (D - B) + (G - E) * (H - F) - X * Y;
    }
};

int main() {

    cout << Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2) << endl;  // 45

    return 0;
}
