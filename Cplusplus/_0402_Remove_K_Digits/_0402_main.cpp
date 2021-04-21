// Created by WXX on 2021/4/21 18:19
#include <iostream>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.9 MB, 在所有 C++ 提交中击败了60.75%的用户
 */
class Solution {
public:
    string removeKdigits(string num, int k) {

        string res = "0";  // 结果可能为0
        for (auto c : num) {
            while (k && c < res.back()) {  // 遇到更小的元素，删除栈顶的元素
                res.pop_back();
                k--;
            }
            res += c;
        }
        while (k--) res.pop_back();

        k = 0;  // 去掉前导0
        while (k + 1 < res.size() && res[k] == '0') k++;
        return res.substr(k);
    }
};

int main() {

    cout << Solution().removeKdigits("1432219", 3) << endl;  // 1219
    cout << Solution().removeKdigits("10200", 1) << endl;  // 200
    cout << Solution().removeKdigits("10", 2) << endl;  // 0

    return 0;
}
