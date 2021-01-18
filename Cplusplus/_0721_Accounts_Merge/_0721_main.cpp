#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

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
// 可以看成一个图，点是邮箱，如果两个邮箱是同一个人的，则有一条边
// 一个人可以对应多个邮箱，但是一个邮箱只能对应一个人
class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>> &accounts) {

        for (int i = 0; i < N; i++) p[i] = i;  // 并查集初始化

        unordered_map<string, int> emailToId;  // (email, id), id用来唯一标识邮箱
        unordered_map<string, string> emailToName;  // (email, username)
        int index = 0;
        for (vector<string> account : accounts) {
            string name = account[0];
            for (int i = 1; i < account.size(); i++) {
                if (!emailToId.count(account[i])) {
                    emailToId[account[i]] = index++;
                    emailToName[account[i]] = name;
                }
            }
        }

        // 根据邮箱合并
        for (vector<string> account : accounts) {
            if (account.size() > 1) {
                int x = emailToId[account[1]];
                for (int i = 2; i < account.size(); i++) {
                    int y = emailToId[account[i]];
                    int p1 = find(x), p2 = find(y);
                    if (p1 != p2) p[p1] = p2;  // 合并邮箱id
                }
            }
        }

        // 将id映射到emails (find(id), emails)
        unordered_map<int, vector<string>> idToEmails;
        for (auto &t : emailToId) {
            string email = t.first;
            int id = t.second;
            int f = find(id);
            idToEmails[f].push_back(email);
        }

        // 根据id得到emails，然后根据任意一个email得到用户名，然后得到(username, emails)
        vector<vector<string>> res;
        for (auto &t : idToEmails) {
            vector<string> emails = t.second;
            sort(emails.begin(), emails.end());
            string name = emailToName[emails[0]];
            vector<string> account = {name};
            for (auto &e : emails) account.push_back(e);
            res.push_back(account);
        }

        return res;
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