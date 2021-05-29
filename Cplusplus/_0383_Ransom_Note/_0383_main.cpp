// Created by WXX on 2021/5/29 18:48
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：20 ms, 在所有 C++ 提交中击败了39.55%的用户
 * 内存消耗：8.6 MB, 在所有 C++ 提交中击败了47.11%的用户
 */
class Solution {
public:
    bool canConstruct(string a, string b) {
        unordered_map<char, int> hash;
        for (auto c : b) hash[c]++;
        for (auto c : a)
            if (!hash[c]) return false;
            else hash[c]--;
        return true;
    }
};

int main() {

    cout << Solution().canConstruct("a", "b") << endl;  // false

    return 0;
}
