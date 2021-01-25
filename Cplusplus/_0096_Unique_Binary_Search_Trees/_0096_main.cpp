// Created by WXX on 2021/1/25 16:16
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int numTrees(int n) {

        vector<int> f(n + 1);
        f[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                f[i] += f[j - 1] * f[i - j];
        return f[n];
    }
};

int main() {

    cout << Solution().numTrees(3) << endl;  // 5

    return 0;
}