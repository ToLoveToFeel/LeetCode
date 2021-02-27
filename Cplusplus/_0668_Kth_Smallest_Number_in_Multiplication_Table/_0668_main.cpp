// Created by WXX on 2021/2/27 23:44
#include <iostream>

using namespace std;

class Solution {
public:
    // 返回小于等于mid的数据个数，将每列中小于mid的数的个数相加即可
    int get(int m, int n, int mid) {
        int res = 0;
        for (int i = 1; i <= n; i++)
            res += min(m, mid / i);
        return res;
    }

    int findKthNumber(int m, int n, int k) {

        int l = 1, r = n * m;
        while (l < r) {
            int mid = l + r >> 1;
            if (get(m, n, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }
};

int main() {

    cout << Solution().findKthNumber(3, 3, 5) << endl;  // 3
    cout << Solution().findKthNumber(2, 3, 6) << endl;  // 6

    return 0;
}
