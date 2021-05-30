// Created by WXX on 2021/5/30 15:07
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了65.04%的用户
 */
class Solution {
public:
    int findNthDigit(int n) {
        long long k = 1, t = 9, s = 1;  // k位数有t个，我们考察的字符在第s个数据中
        while (n > k * t) {
            n -= k * t;
            k++, t *= 10, s *= 10;
        }
        s += (n + k - 1) / k - 1;  // n/k上取整=(n+k-1)/k下取整
        n = n % k ? n % k : k;
        return to_string(s)[n - 1] - '0';
    }
};

int main() {

    cout << Solution().findNthDigit(3) << endl;  // 3

    return 0;
}
