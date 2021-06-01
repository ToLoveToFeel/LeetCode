// Created by WXX on 2021/6/1 9:01
#include <iostream>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:

    string name[10] = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };
    int ord[10] = {0, 8, 3, 2, 6, 4, 5, 1, 7, 9};
    unordered_map<char, int> hash;

    string originalDigits(string s) {
        for (auto c : s) hash[c]++;
        string res;
        for (int x : ord) {
            while (true) {
                bool flag = true;
                for (auto c : name[x])
                    if (!hash[c]) {
                        flag = false;
                        break;
                    }
                if (flag) {
                    res += to_string(x);
                    for (auto c : name[x]) hash[c]--;
                } else break;
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};

int main() {

    cout << Solution().originalDigits("owoztneoer") << endl;  // 012

    return 0;
}
