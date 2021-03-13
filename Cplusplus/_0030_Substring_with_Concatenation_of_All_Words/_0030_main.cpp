// Created by WXX on 2021/3/13 21:44
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

// 时间复杂度：O(n*w)
/**
 * 执行用时：112 ms, 在所有 C++ 提交中击败了63.30%的用户
 * 内存消耗：41 MB, 在所有 C++ 提交中击败了26.94%的用户
 */
class Solution {
public:
    vector<int> findSubstring(string s, vector<string> &words) {

        vector<int> res;
        if (words.empty()) return res;
        int n = s.size(), m = words.size(), w = words[0].size();
        unordered_map<string, int> tot;
        for (auto &word : words) tot[word]++;

        for (int i = 0; i < w; i++) {
            unordered_map<string, int> wd;  // windows的缩写
            int cnt = 0;
            for (int j = i; j + w - 1 < n; j += w) {  // 滑动窗口
                if (j >= i + m * w) {
                    auto word = s.substr(j - m * w, w);
                    wd[word]--;
                    if (wd[word] < tot[word]) cnt--;
                }
                auto word = s.substr(j, w);
                wd[word]++;
                if (wd[word] <= tot[word]) cnt++;
                if (cnt == m) res.push_back(j - (m - 1) * w);
            }
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

    string s = "barfoothefoobarman";
    vector<string> words = {"foo", "bar"};
    OutputBasicArray1D(Solution().findSubstring(s, words));

    return 0;
}
