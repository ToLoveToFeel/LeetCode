// Created by WXX on 2021/1/29 21:35
#include <iostream>
#include <vector>

using namespace std;

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
