// Created by WXX on 2021/4/22 13:48
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxArea(vector<int> &h) {

        int res = 0;
        int i = 0, j = h.size() - 1;
        while (i < j) {
            res = max(res, min(h[i], h[j]) * (j - i));
            if (h[i] > h[j]) j--;
            else i++;
        }
        return res;
    }
};

int main() {

    vector<int> h = {1, 8, 6, 2, 5, 4, 8, 3, 7};  // 49
    cout << Solution().maxArea(h) << endl;

    return 0;
}
