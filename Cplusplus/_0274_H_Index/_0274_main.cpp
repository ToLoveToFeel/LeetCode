// Created by WXX on 2021/1/29 21:21
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了85.15%的用户
 * 内存消耗：8.3 MB, 在所有 C++ 提交中击败了97.89%的用户
 */
class Solution {
public:
    int hIndex(vector<int> &c) {

        sort(c.begin(), c.end(), greater<int>());  // 从大到小排列
        for (int h = c.size(); h; h--)
            if (c[h - 1] >= h)
                return h;
        return 0;
    }
};

int main() {

    vector<int> c = {3, 0, 6, 1, 5};
    cout << Solution().hIndex(c) << endl;  // 3

}
