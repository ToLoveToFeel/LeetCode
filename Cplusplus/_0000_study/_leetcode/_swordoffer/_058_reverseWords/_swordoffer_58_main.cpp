// Created by WXX on 2021/7/19 21:53
#include <iostream>
#include <algorithm>

using namespace std;

// 思路：分为两步：(1) 将每个单词翻转；(2) 将句子翻转
class Solution {
public:
    string reverseWords(string s) {

        int k = 0;
        for (int i = 0; i < s.size(); i++) {
            // [i, j)在原字符串中移动，[k, t)在新字符串中移动
            if (s[i] == ' ') continue;
            int j = i, t = k;
            while (j < s.size() && s[j] != ' ') s[t++] = s[j++];
            reverse(s.begin() + k, s.begin() + t);
            s[t++] = ' ';
            k = t, i = j;
        }
        if (k) k--;
        s.erase(s.begin() + k, s.end());
        reverse(s.begin(), s.end());
        return s;
    }
};

int main() {

    string s = "the sky is blue";
    cout << Solution().reverseWords(s);

    return 0;
}
