// Created by WXX on 2021/5/5 10:37
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> expr;  // 记录s中的数字和运算符，方便处理

    vector<int> diffWaysToCompute(string s) {

        for (int i = 0; i < s.size(); i++) {
            if (isdigit(s[i])) {  // 说明是数字
                int j = i, x = 0;
                while (j < s.size() && isdigit(s[j])) x = x * 10 + (s[j++] - '0');
                i = j - 1;
                expr.push_back(to_string(x));
            } else expr.push_back(s.substr(i, 1));  // 说明是运算符
        }

        return dfs(0, expr.size() - 1);
    }

    vector<int> dfs(int l, int r) {
        if (l == r) return {stoi(expr[l])};  // 此时是单个数字

        vector<int> res;
        for (int i = l + 1; i < r; i += 2) {  // 枚举所有运算符
            auto left = dfs(l, i - 1), right = dfs(i + 1, r);
            for (auto x : left)
                for (auto y : right) {
                    int z = 0;
                    if (expr[i] == "+") z = x + y;
                    else if (expr[i] == "-") z = x - y;
                    else z = x * y;
                    res.push_back(z);
                }
        }
        return res;
    }
};

void OutputBasicArray1D(vector<int> nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    OutputBasicArray1D(Solution().diffWaysToCompute("2-1-1"));
    OutputBasicArray1D(Solution().diffWaysToCompute("2*3-4*5"));

    return 0;
}
