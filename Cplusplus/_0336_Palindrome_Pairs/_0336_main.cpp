// Created by WXX on 2021/2/25 20:31
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

// 时间复杂度：O(n * L^2)  n为字符串数量，L为字符串平均长度
class Solution {
public:
    bool check(string &s) {
        for (int i = 0, j = s.size() - 1; i < j; i++, j--)
            if (s[i] != s[j])
                return false;
        return true;
    }

    vector<vector<int>> palindromePairs(vector<string> &words) {

        unordered_map<string, int> hash;  // (字符串的反序，索引位置)
        for (int i = 0; i < words.size(); i++) {
            auto w = words[i];
            reverse(w.begin(), w.end());
            hash[w] = i;
        }

        vector<vector<int>> res;
        for (int i = 0; i < words.size(); i++) {
            auto w = words[i];
            for (int j = 0; j <= w.size(); j++) {
                auto left = w.substr(0, j), right = w.substr(j);
                // 分析中的第一种情况
                if (check(right) && hash.count(left) && hash[left] != i) res.push_back({i, hash[left]});
                // 分析中的第二种情况
                if (check(left) && hash.count(right) && hash[right] != i && w.size() != words[hash[right]].size())
                    res.push_back({hash[right], i});
            }
        }
        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<string> words = {"abcd", "dcba", "lls", "s", "sssll"};
    OutputBasicArray2D1(Solution().palindromePairs(words));

    return 0;
}
