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
//class Solution {
//public:
//    vector<int> findSubstring(string s, vector<string> &words) {
//
//        vector<int> res;
//        if (words.empty()) return res;
//        int n = s.size(), m = words.size(), w = words[0].size();
//        unordered_map<string, int> tot;
//        for (auto &word : words) tot[word]++;
//
//        for (int i = 0; i < w; i++) {
//            unordered_map<string, int> wd;  // windows的缩写
//            int cnt = 0;
//            for (int j = i; j + w - 1 < n; j += w) {  // 滑动窗口
//                // 滑窗为[j-m*w, j)
//                // 每次滑入[j, j+w-1], 滑出[j-m*w, j-m*w+w-1]
//                if (j >= i + m * w) {
//                    auto word = s.substr(j - m * w, w);
//                    wd[word]--;
//                    if (wd[word] < tot[word]) cnt--;
//                }
//                auto word = s.substr(j, w);
//                wd[word]++;
//                if (wd[word] <= tot[word]) cnt++;
//                if (cnt == m) res.push_back(j - (m - 1) * w);
//            }
//        }
//        return res;
//    }
//};

class Solution {
public:
    typedef unsigned long long ULL;

    static const int P = 131;

    ULL get(ULL h[], ULL p[], int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }

    vector<int> findSubstring(string s, vector<string> &words) {

        vector<int> res;
        if (words.empty()) return res;
        int n = s.size(), m = words.size(), w = words[0].size();

        // 求s的字符串哈希结果, 从1开始，即h[1]=s[0], 后面求hash值的时候要加上一个偏移量
        ULL h[n + 10], p[n + 10];  // p[i] = 10 ^ i
        h[0] = 0, p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s[i - 1];
            p[i] = p[i - 1] * P;
        }

        // 统计words中每个单词出现的次数
        unordered_map<ULL, int> tot;
        for (auto &word : words) {
            ULL t = 0;
            for (auto c : word) t = t * P + c;
            tot[t]++;
        }

        for (int i = 0; i < w; i++) {
            unordered_map<ULL, int> wd;  // windows的缩写
            int cnt = 0;
            for (int j = i; j + w - 1 < n; j += w) {  // 滑动窗口
                // 滑窗为[j-m*w, j)
                // 每次滑入[j, j+w-1], 滑出[j-m*w, j-m*w-1]
                if (j >= i + m * w) {
                    // 获取单词s[j - m * w, j - m * w + w - 1]对应的哈希值
                    ULL hash = get(h, p, j - m * w + 1, j - m * w + w);
                    wd[hash]--;
                    if (wd[hash] < tot[hash]) cnt--;
                }
                // 获取单词s[j, j + w - 1]对应的哈希值
                ULL hash = get(h, p, j + 1, j + w);
                wd[hash]++;
                if (wd[hash] <= tot[hash]) cnt++;
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
