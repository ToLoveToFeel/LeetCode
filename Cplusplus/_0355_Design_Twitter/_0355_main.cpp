// Created by WXX on 2021/5/11 21:58
#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <queue>

using namespace std;

typedef pair<int, int> PII;  // (推特发表时间, 推特id)

#define x first
#define y second

class Twitter {
public:

    unordered_map<int, vector<PII>> tweets;  // (用户id, 发表的推特)
    unordered_map<int, unordered_set<int>> follows;  // (用户id, 该用户关注的人)
    int ts;

    /** Initialize your data structure here. */
    Twitter() {
        ts = 0;
    }

    /** Compose a new tweet. */
    void postTweet(int userId, int tweetId) {
        tweets[userId].push_back({ts++, tweetId});
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    vector<int> getNewsFeed(int u) {
        priority_queue<vector<int>> heap;  // (推特时间戳, 推特id, 该用户的第几个推特, 用户id)
        follows[u].insert(u);  // 为了处理方便，让自己关注自己
        for (auto userId : follows[u]) {  // u关注的人的userId
            auto &ts = tweets[userId];  // 此人发表的推特
            if (ts.size()) {
                int i = ts.size() - 1;
                heap.push({ts[i].x, ts[i].y, i, userId});
            }
        }

        vector<int> res;
        for (int i = 0; i < 10 && heap.size(); i++) {
            auto t = heap.top(); heap.pop();
            res.push_back(t[1]);

            int j = t[2];
            if (j) {
                j--;
                int userId = t[3];
                auto &ts = tweets[userId];
                heap.push({ts[j].x, ts[j].y, j, userId});
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    void follow(int x, int y) {
        follows[x].insert(y);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    void unfollow(int x, int y) {
        follows[x].erase(y);
    }
};

int main() {


    return 0;
}
