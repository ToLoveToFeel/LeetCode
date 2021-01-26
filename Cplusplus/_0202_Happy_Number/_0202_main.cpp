// Created by WXX on 2021/1/26 19:21
#include <iostream>
#include <unordered_set>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了63.72%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了76.03%的用户
 */
class Solution {
public:
    bool isHappy(int n) {

        unordered_set<int> hash;
        n = get(n);
        while (!hash.count(n)) {
            hash.insert(n);
            n = get(n);
        }
        return hash.count(1) == 1;
    }

    int get(int x) {
        int res = 0;
        while (x) {
            res += (x % 10) * (x % 10);
            x /= 10;
        }
        return res;
    }
};

int main() {

    cout << Solution().isHappy(19) << endl;  // true

    return 0;
}
