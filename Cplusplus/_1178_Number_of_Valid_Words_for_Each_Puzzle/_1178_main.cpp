// Created by WXX on 2021/2/26 9:43
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

// 哈希表+位运算
/**
 * 执行用时：228 ms, 在所有 C++ 提交中击败了75.38%的用户
 * 内存消耗：40.9 MB, 在所有 C++ 提交中击败了50.77%的用户
 */
class Solution {
public:
    vector<int> findNumOfValidWords(vector<string> &words, vector<string> &puzzles) {

        unordered_map<int, int> hash;  // (word的二进制表示(1代表有该字母)，次数)
        for (auto &word : words) {
            int s = 0;
            for (auto c : word)
                s |= 1 << (c - 'a');
            hash[s]++;
        }

        vector<int> res;
        for (auto &p : puzzles) {
            int cnt = 0;
            for (int mask = 0; mask < (1 << 6); mask++) {
                int s = 1 << (p[0] - 'a');
                for (int i = 0; i < 6; i++)
                    if (mask & (1 << i))
                        s |= 1 << (p[i + 1] - 'a');
                cnt += hash[s];
            }
            res.push_back(cnt);
        }
        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<string> words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
    vector<string> puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
    OutputBasicArray1D(Solution().findNumOfValidWords(words, puzzles));

    return 0;
}
