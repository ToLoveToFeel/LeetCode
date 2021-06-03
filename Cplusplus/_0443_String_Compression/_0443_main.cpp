// Created by WXX on 2021/6/3 10:55
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int compress(vector<char> &chs) {
        int k = 0;
        for (int i = 0; i < chs.size(); i++) {
            int j = i;
            while (j < chs.size() && chs[j] == chs[i]) j++;
            int cnt = j - i;
            chs[k++] = chs[i];
            if (cnt > 1) {
                auto s = to_string(cnt);
                for (auto c : s) chs[k++] = c;
            }
            i = j - 1;
        }
        return k;
    }
};

int main() {

    vector<char> chs = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    cout << Solution().compress(chs) << endl;  // 6

    return 0;
}
