// Created by WXX on 2021/1/30 20:19
#include <iostream>
#include <vector>
#include <sstream>
#include <unordered_map>

using namespace std;

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.3 MB, 在所有 C++ 提交中击败了98.45%的用户
 */
class Solution {
public:
    bool wordPattern(string pattern, string s) {

        vector<string> words;
        stringstream ssin(s);
        string word;
        while (ssin >> word) words.push_back(word);

        if (pattern.size() != words.size()) return false;

        unordered_map<char, string> pw;
        unordered_map<string, char> wp;
        for (int i = 0; i < pattern.size(); i++) {
            auto a = pattern[i];
            auto b = words[i];
            if (pw.count(a) && pw[a] != b) return false;
            pw[a] = b;
            if (wp.count(b) && wp[b] != a) return false;
            wp[b] = a;
        }
        return true;
    }
};

int main() {

    cout << Solution().wordPattern("abba", "dog cat cat dog") << endl;  // true;
    cout << Solution().wordPattern("abba", "dog cat cat fish") << endl;  // false
    cout << Solution().wordPattern("aaaa", "dog cat cat dog") << endl;  // false
    cout << Solution().wordPattern("abba", "dog dog dog dog") << endl;  // false

    return 0;
}
