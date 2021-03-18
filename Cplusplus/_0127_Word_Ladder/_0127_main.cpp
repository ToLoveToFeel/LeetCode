// Created by WXX on 2021/3/18 10:07
#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <unordered_set>

using namespace std;

/**
 * 执行用时：160 ms, 在所有 C++ 提交中击败了59.48%的用户
 * 内存消耗：15.7 MB, 在所有 C++ 提交中击败了34.35%的用户
 */
class Solution {
public:
    unordered_set<string> S;
    unordered_map<string, int> dist;  // 距离数组，同时具有判重的作用
    queue<string> q;

    int ladderLength(string beginWord, string endWord, vector<string> &wordList) {

        for (auto word : wordList) S.insert(word);
        dist[beginWord] = 0;
        q.push(beginWord);
        while (q.size()) {
            auto t = q.front();
            q.pop();

            string r = t;
            for (int i = 0; i < t.size(); i++) {
                t = r;
                for (char j = 'a'; j <= 'z'; j++) {
                    t[i] = j;
                    if (S.count(t) && dist.count(t) == 0) {
                        dist[t] = dist[r] + 1;
                        if (t == endWord) break;
                        q.push(t);
                    }
                }
            }
        }
        return dist[endWord] != 0 ? dist[endWord] + 1 : 0;
    }
};

int main() {

    vector<string> wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
    cout << Solution().ladderLength("hit", "cog", wordList) << endl;

    return 0;
}
