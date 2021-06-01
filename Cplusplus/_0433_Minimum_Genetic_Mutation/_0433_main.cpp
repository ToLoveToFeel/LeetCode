// Created by WXX on 2021/6/1 19:49
#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <queue>

using namespace std;

class Solution {
public:
    int minMutation(string start, string end, vector<string> &bank) {
        unordered_set<string> S;
        for (auto &s : bank) S.insert(s);
        unordered_map<string, int> dist;
        queue <string> q;
        q.push(start);
        dist[start] = 0;
        char chs[] = {'A', 'T', 'G', 'C'};
        while (q.size()) {
            auto t = q.front();
            q.pop();
            for (int i = 0; i < t.size(); i++) {
                auto s = t;
                for (auto c : chs) {
                    s[i] = c;
                    if (S.count(s) && dist.count(s) == 0) {
                        dist[s] = dist[t] + 1;
                        if (s == end) return dist[s];
                        q.push(s);
                    }
                }
            }
        }
        return -1;
    }
};

int main() {

    vector<string> bank = {"AACCGGTA"};
    cout << Solution().minMutation("AACCGGTT", "AACCGGTA", bank) << endl;  // 1

    return 0;
}
