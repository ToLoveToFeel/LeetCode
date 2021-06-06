#include <iostream>
#include <vector>
#include <unordered_map>
#include <set>

using namespace std;

const int N = 10010;

int p[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

/**
 * 执行用时：108 ms, 在所有 C++ 提交中击败了99.61%的用户
 * 内存消耗：38.3 MB, 在所有 C++ 提交中击败了31.40%的用户
 */
// 一个人可以对应多个邮箱，但是一个邮箱只能对应一个人且同一个邮箱对应的人名一定相同
class Solution {
public:

    vector<int> p;

    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        int n = accounts.size();
        for (int i = 0; i < n; i++) p.push_back(i);
        // (1) 将同一个邮件对应的账户id(使用下标表示账户的id)放到一个集合中
        unordered_map<string, vector<int>> hash;
        for (int i = 0; i < n; i++)
            for (int j = 1; j < accounts[i].size(); j++)
                hash[accounts[i][j]].push_back(i);
        // (2) 将同一个邮件对应的账户id合并
        for (auto &[k, v] : hash)
            for (int i = 1; i < v.size(); i++)
                p[find(v[i])] = find(v[0]);
        // (3) 合并账户
        vector<set<string>> res(n);
        for (int i = 0; i < n; i++)
            for (int j = 1; j < accounts[i].size(); j++)
                res[find(i)].insert(accounts[i][j]);
        // (4) 按照题目要求返回结果
        vector<vector<string>> ans;
        for (int i = 0; i < n; i++)
            if (res[i].size()) {
                vector<string> t;
                t.push_back(accounts[i][0]);  // 姓名
                for (auto &e : res[i]) t.push_back(e);
                ans.push_back(t);
            }
        return ans;
    }
};

void OutputBasicArray2D1(vector<vector<string>> &nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<string>> accounts = {
            {"John", "johnsmith@mail.com", "john00@mail.com"},
            {"John", "johnnybravo@mail.com"},
            {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
            {"Mary", "mary@mail.com"}
    };
    vector<vector<string>> res = Solution().accountsMerge(accounts);
    OutputBasicArray2D1(res);

    return 0;
}