// Created by WXX on 2021/1/29 21:43
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.9 MB, 在所有 C++ 提交中击败了86.70%的用户
 */
class Solution {
public:
    int firstBadVersion(int n) {

        int l = 1, r = n;
        while (l < r) {
            int mid = (long long)l + r >> 1;
            if (isBadVersion(mid))
                r = mid;
            else l = mid + 1;
        }
        return l;
    }

private:
    bool isBadVersion(int n) {
        return n >= 3;
    }
};

int main() {

    cout << Solution().firstBadVersion(5) << endl;

    return 0;
}
