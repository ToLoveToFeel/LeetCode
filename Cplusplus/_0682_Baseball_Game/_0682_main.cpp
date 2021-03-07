// Created by WXX on 2021/3/7 20:25
#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

// 模拟题
class Solution {
public:
    int calPoints(vector<string> &ops) {
        vector<int> stk;
        for (auto &s : ops) {
            int p = stk.size() - 1;
            if (s == "+") stk.push_back(stk[p - 1] + stk[p]);
            else if (s == "D") stk.push_back(stk[p] * 2);
            else if (s == "C") stk.pop_back();
            else stk.push_back(stoi(s));
        }
        return accumulate(stk.begin(), stk.end(), 0);
    }
};

int main() {

    vector<string> ops = {"5", "2", "C", "D", "+"};
    cout << Solution().calPoints(ops) << endl;  // 30

    return 0;
}
