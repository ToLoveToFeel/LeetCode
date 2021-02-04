// Created by WXX on 2021/1/29 22:18
#include <iostream>
#include <vector>

using namespace std;

typedef long long LL;

// https://www.acwing.com/video/1644/
/**
 * 执行用时：44 ms, 在所有 C++ 提交中击败了91.30%的用户
 * 内存消耗：14.5 MB, 在所有 C++ 提交中击败了76.24%的用户
 */
class Solution {
public:

    vector<string> ans;
    string path;

    vector<string> addOperators(string num, int target) {
        path.resize(100);
        dfs(num, 0, 0, 0, 1, target);
        return ans;
    }

    // 对num[u...)添加 运算符使得最终组成的表达式值为target,答案存在path中,len记录path考察到的下标
    // 代数结构：a + b * ?       其中?代表下一个需要考察的数字，设为c: a + b * c
    // 如果考察+号：(a+b*c) + 1 * ?
    // 如果考察-号：(a+b*c) + (-1) * ?
    // 如果考察*号：a + (b * c) * ?
    void dfs(string &num, int u, int len, LL a, LL b, int target) {
        if (u == num.size()) {
            if (a == target) ans.push_back(path.substr(0, len - 1));
        } else {
            LL c = 0;
            for (int i = u; i < num.size(); i++) {
                c = c * 10 + num[i] - '0';
                path[len++] = num[i];

                // +，只有加号才能考察最后一位，这样a就是最后的结果
                path[len] = '+';
                dfs(num, i + 1, len + 1, a + b * c, 1, target);
                if (i + 1 < num.size()) {  // i + 1代表不是最后一位
                    // -
                    path[len] = '-';
                    dfs(num, i + 1, len + 1, a + b * c, -1, target);

                    // *
                    path[len] = '*';
                    dfs(num, i + 1, len + 1, a, b * c, target);
                }
                if (num[u] == '0') break;  // 不能出现两个0
            }
        }
    }
};

void OutputBasicArray1D(vector<string> &nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i];
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    string num = "123";
    int target = 6;
    vector<string> res = Solution().addOperators(num, target);
    OutputBasicArray1D(res);

    return 0;
}
