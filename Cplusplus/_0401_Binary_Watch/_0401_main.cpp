// Created by WXX on 2021/4/7 9:03
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.3 MB, 在所有 C++ 提交中击败了78.74%的用户
 */
class Solution {
public:
    vector<string> readBinaryWatch(int n) {

        vector<string> res;
        char str[10];
        for (int i = 0; i < 1 << 10; i++) {
            int s = 0;  // 记录二进制表示中1的个数
            for (int j = 0; j < 10; j++)
                if (i >> j & 1)
                    s++;
            if (s == n) {
                int a = i >> 6, b = i & 63;
                if (a < 12 && b < 60) {
                    sprintf(str, "%d:%02d", a, b);
                    res.push_back(str);
                }
            }
        }
        return res;
    }
};

void OutputBasicArray1D(vector<string> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    OutputBasicArray1D(Solution().readBinaryWatch(1));

    return 0;
}
