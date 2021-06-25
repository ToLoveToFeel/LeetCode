// Created by WXX on 2021/6/25 9:13
#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <queue>

using namespace std;

class Solution {
public:
    int openLock(vector<string> &deadends, string target) {
        string start = "0000";
        if (start == target) return 0;
        unordered_set<string> S;
        for (auto &s : deadends) S.insert(s);
        if (S.count(start)) return -1;

        queue<string> q;
        q.push(start);
        unordered_map<string, int> dist;
        dist[start] = 0;
        while (q.size()) {
            auto t = q.front();
            q.pop();
            for (int i = 0; i < 4; i++)
                for (int j = -1; j <= 1; j += 2) {
                    auto state = t;
                    state[i] = (state[i] - '0' + j + 10) % 10 + '0';
                    if (!S.count(state) && !dist.count(state)) {
                        dist[state] = dist[t] + 1;
                        if (state == target) return dist[state];
                        q.push(state);
                    }
                }
        }
        return -1;
    }
};

int main() {

    vector<string> deadends = {"0201","0101","0102","1212","2002"};
    string target = "0202";
    cout << Solution().openLock(deadends, target) << endl;  // 6

    return 0;
}