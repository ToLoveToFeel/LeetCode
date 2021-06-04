// Created by WXX on 2021/6/4 9:34
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;

class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> cnt;
        for (auto c : s) cnt[c]++;
        sort(s.begin(), s.end(), [&](char a, char b) {  // 因为要传入cnt, 所以要加&
            if (cnt[a] != cnt[b]) return cnt[a] > cnt[b];
            return a < b;
        });
        return s;
    }
};

int main() {

    cout << Solution().frequencySort("tree") << endl;  // eert

    return 0;
}
