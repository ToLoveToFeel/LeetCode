// Created by WXX on 2021/4/17 17:00
#include <iostream>
#include <algorithm>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了54.74%的用户
 */
class Solution {
public:
    string convertToTitle(int n) {

        string res;
        while (n) {
            n--;
            res += n % 26 + 'A';
            n /= 26;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

int main() {

    cout << Solution().convertToTitle(2019) << endl;  // BYQ

    return 0;
}
