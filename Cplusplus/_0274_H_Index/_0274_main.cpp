// Created by WXX on 2021/1/29 21:21
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

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
