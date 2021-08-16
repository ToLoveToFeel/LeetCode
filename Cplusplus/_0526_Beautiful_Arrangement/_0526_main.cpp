// Created by ToLoveToFeel on 2021/8/16 09:48
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int countArrangement(int n) {
        vector<int> f(1 << n);
        f[0] = 1;
        for (int i = 0; i < 1 << n; i++) {
            int k = 0;
            for (int j = 0; j < n; j++)
                if (i >> j & 1)
                    k++;
            for (int j = 0; j < n; j++)
                if (!(i >> j & 1)) {  // 第k+1位上的数字为j+1
                    if ((j + 1) % (k + 1) == 0 || (k + 1) % (j + 1) == 0)
                        f[i | (1 << j)] += f[i];
                }
        }
        return f[(1 << n) - 1];
    }
};

int main() {

    cout << Solution().countArrangement(2) << endl;  // 2

    return 0;
}
