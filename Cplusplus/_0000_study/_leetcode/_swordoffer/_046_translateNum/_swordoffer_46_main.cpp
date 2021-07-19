// Created by WXX on 2021/7/19 17:23
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int translateNum(int num) {
        string s = to_string(num);
        int n = s.size();
        s = ' ' + s;
        vector<int> f(n + 1);
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] += f[i - 1];
            if (i > 1) {
                int t = (s[i - 1] - '0') * 10 + s[i] - '0';
                if (t >= 10 && t <= 25) f[i] += f[i - 2];
            }
        }
        return f[n];
    }
};

int main() {

    cout << Solution().translateNum(12258) << endl;  // 5

    return 0;
}
