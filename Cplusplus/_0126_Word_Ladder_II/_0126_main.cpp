// Created by WXX on 2021/3/17 21:49
#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>

using namespace std;

// 思路：分为两步：(1) 正向bfs，求出起点到其他点的最短距离，用于剪枝 (2) 反向暴搜
/**
 * 执行用时：144 ms, 在所有 C++ 提交中击败了76.80%的用户
 * 内存消耗：15.5 MB, 在所有 C++ 提交中击败了75.43%的用户
 */
class Solution {
public:
    unordered_set<string> S;
    unordered_map<string, int> dist;  // 距离数组，同时具有判重的作用
    queue<string> q;
    vector<vector<string>> ans;
    vector<string> path;
    string beginWord;

    vector<vector<string>> findLadders(string _beginWord, string endWord, vector<string> &wordList) {

        for (auto word : wordList) S.insert(word);
        beginWord = _beginWord;
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

        if (!dist.count(endWord)) return ans;
        path.push_back(endWord);
        dfs(endWord);
        return ans;
    }

    void dfs(string t) {
        if (t == beginWord) {
            reverse(path.begin(), path.end());
            ans.push_back(path);
            reverse(path.begin(), path.end());
        } else {
            string r = t;
            for (int i = 0; i < t.size(); i++) {
                t = r;
                for (char j = 'a'; j <= 'z'; j++) {
                    t[i] = j;
                    // 不能使用S.count(t), 因为起点不一定在S中
                    // dist[t] 表示t到起点的距离, 这里进行了剪枝
                    if (dist.count(t) && dist[t] + 1 == dist[r]) {
                        path.push_back(t);
                        dfs(t);
                        path.pop_back();
                    }
                }
            }
        }
    }
};

void OutputBasicArray2D(vector<vector<string>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        if (i > 0 && i < nums.size()) cout << ' ';
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", " << endl;
    }
    cout << "]" << endl;
}

int main() {

    vector<string> wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
    OutputBasicArray2D(Solution().findLadders("hit", "cog", wordList));

    return 0;
}
