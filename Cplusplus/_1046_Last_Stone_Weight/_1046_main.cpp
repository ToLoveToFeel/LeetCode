// Created by WXX on 2021/6/8 10:14
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    int lastStoneWeight(vector<int> &stones) {
        priority_queue<int> heap;
        for (auto x : stones) heap.push(x);
        while (heap.size() > 1) {
            int y = heap.top(); heap.pop();
            int x = heap.top(); heap.pop();
            if (x == y) continue;
            heap.push(y - x);
        }
        return heap.size() == 1 ? heap.top() : 0;
    }
};

int main() {

    vector<int> stones = {2, 7, 4, 1, 8, 1};
    cout << Solution().lastStoneWeight(stones) << endl;  // 1

    return 0;
}
