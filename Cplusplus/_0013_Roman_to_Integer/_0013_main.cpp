// Created by WXX on 2021/4/22 15:00
#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int romanToInt(string s) {

        unordered_map<char, int> hash;
        hash['I'] = 1; hash['V'] = 5;
        hash['X'] = 10, hash['L'] = 50;
        hash['C'] = 100, hash['D'] = 500;
        hash['M'] = 1000;

        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            if (i + 1 < s.size() && hash[s[i]] < hash[s[i + 1]]) res -= hash[s[i]];
            else res += hash[s[i]];
        }
        return res;
    }
};

int main() {

    cout << Solution().romanToInt("III") << endl;  // 3

    return 0;
}
