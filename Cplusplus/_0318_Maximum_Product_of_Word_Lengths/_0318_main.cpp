// Created by WXX on 2021/2/22 15:43
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProduct(vector<string> &words) {

        vector<int> state;  // 记录每个字符串出现了哪些字母
        for (auto word : words) {
            int s = 0;
            for (auto c : word)
                s |= 1 << (c - 'a');
            state.push_back(s);
        }

        int res = 0;
        for (int i = 0; i < words.size(); i++)
            for (int j = i + 1; j < words.size(); j++)
                if ((state[i] & state[j]) == 0)
                    res = max(res, (int) (words[i].size() * words[j].size()));
        return res;
    }
};

int main() {

    vector<string> words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    cout << Solution().maxProduct(words) << endl;  // 16

    return 0;
}
