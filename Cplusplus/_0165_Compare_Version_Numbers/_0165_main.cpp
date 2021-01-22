// Created by WXX on 2021/1/22 20:13
#include <iostream>

using namespace std;

class Solution {
public:
    int compareVersion(string v1, string v2) {

        for (int i = 0, j = 0; i < v1.size() || j < v2.size();) {
            int a = i, b = j;
            while (a < v1.size() && v1[a] != '.') a++;
            while (b < v2.size() && v2[b] != '.') b++;
            int x = (a == i ? 0 : stoi(v1.substr(i, a - i)));  // substr(起点，长度)
            int y = (b == j ? 0 : stoi(v2.substr(j, b - j)));
            if (x > y) return 1;
            if (x < y) return -1;
            i = a + 1, j = b + 1;  // +1是为了跳过 .
        }
        return 0;
    }
};

int main() {

    string v1 = "1.01";
    string v2 = "1.001";
    cout << Solution().compareVersion(v1, v2) << endl;  // 0

    return 0;
}
