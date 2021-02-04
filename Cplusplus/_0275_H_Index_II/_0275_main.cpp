// Created by WXX on 2021/1/29 21:35
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：12 ms, 在所有 C++ 提交中击败了99.34%的用户
 * 内存消耗：17.5 MB, 在所有 C++ 提交中击败了89.32%的用户
 */
class Solution {
public:
    int hIndex(vector<int> &c) {

        int n = c.size();
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (c[n - mid] >= mid) l = mid;
            else r = mid - 1;
        }
        return r;
    }
};

int main() {

    vector<int> c = {0, 1, 3, 5, 6};
    cout << Solution().hIndex(c) << endl;  // 3

    return 0;
}
