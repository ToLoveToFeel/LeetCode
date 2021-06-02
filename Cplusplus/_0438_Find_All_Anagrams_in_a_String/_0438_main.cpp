// Created by WXX on 2021/6/2 18:35
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了34.83%的用户
 * 内存消耗：8.4 MB, 在所有 C++ 提交中击败了61.09%的用户
 */
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if (s.size() < p.size()) return {};
        unordered_map<char, int> hash;
        for (auto c : p) hash[c]++;
        vector<int> res;
        unordered_map<char, int> wd;
        for (int i = 0, j = 0, cnt = 0; i < s.size(); i++) {
            if (i - j + 1 > p.size()) {
                wd[s[j]]--;
                if (wd[s[j]] < hash[s[j]]) cnt--;
                j++;
            }
            wd[s[i]]++;
            if (wd[s[i]] <= hash[s[i]]) cnt++;
            if (cnt == p.size()) res.push_back(j);
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

    OutputBasicArray1D(Solution().findAnagrams("cbaebabacd", "abc"));  // [0, 6]

    return 0;
}
