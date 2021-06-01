// Created by WXX on 2021/6/1 20:08
#include <iostream>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了26.56%的用户
 * 内存消耗：6 MB, 在所有 C++ 提交中击败了70.10%的用户
 */
class Solution {
public:
    int countSegments(string s) {
        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == ' ') continue;
            int j = i;
            while (j < s.size() && s[j] != ' ') j++;
            res++;
            i = j - 1;
        }
        return res;
    }
};

int main() {

    cout << Solution().countSegments("Hello, my name is John") << endl;  // 5

    return 0;
}
