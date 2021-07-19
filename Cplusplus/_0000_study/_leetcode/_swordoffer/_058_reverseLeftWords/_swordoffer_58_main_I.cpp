// Created by WXX on 2021/7/19 21:59
#include <iostream>

using namespace std;

class Solution {
public:
    string reverseLeftWords(string s, int k) {
        return s.substr(k) + s.substr(0, k);
    }
};

int main() {

    cout << Solution().reverseLeftWords("abcdefg", 2) << endl;  // cdefgab

    return 0;
}
