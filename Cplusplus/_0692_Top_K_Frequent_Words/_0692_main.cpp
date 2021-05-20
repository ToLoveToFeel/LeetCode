// Created by WXX on 2021/5/20 9:10
#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    typedef pair<int, string> PIS;  // (key出现的次数, key)

    vector<string> topKFrequent(vector<string> &words, int k) {
        unordered_map<string, int> hash;
        for (auto w : words) hash[w]++;
        vector<PIS> ws;
        for (auto[k, v] : hash) ws.push_back({v, k});

        auto cmp = [](PIS a, PIS b) {  // 第一维降序，第二维升序
            if (a.first != b.first) return a.first < b.first;
            return a.second > b.second;
        };
        make_heap(ws.begin(), ws.end(), cmp);  // 线性建堆

        vector<string> res;
        while (k--) {
            res.push_back(ws[0].second);
            pop_heap(ws.begin(), ws.end(), cmp);
            ws.pop_back();
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

    vector<string> words = {"i", "love", "leetcode", "i", "love", "coding"};
    OutputBasicArray1D(Solution().topKFrequent(words, 2));

    return 0;
}
