// Created by WXX on 2021/7/13 9:33
#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

/**
 * 执行用时：28 ms, 在所有 C++ 提交中击败了92.88%的用户
 * 内存消耗：14.4 MB, 在所有 C++ 提交中击败了69.42%的用户
 */
class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>> &buildings) {
        vector<vector<int>> res;

        vector<pair<int, int>> points;
        for (auto &b : buildings) {
            points.push_back({b[0], -b[2]});  // 左端点
            points.push_back({b[1], b[2]});  // 右端点
        }
        sort(points.begin(), points.end());

        multiset<int> heights;
        heights.insert(0);
        for (auto &p : points) {
            int x = p.first, h = abs(p.second);
            if (p.second < 0) {  // 左端点
                if (h > *heights.rbegin()) res.push_back({x, h});
                heights.insert(h);
            } else {  // 右端点
                heights.erase(heights.find(h));  // 只能删除一个h
                if (h > *heights.rbegin()) res.push_back({x, *heights.rbegin()});
            }
        }
        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
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

//    vector<vector<int>> buildings = {{2,  9,  10},
//                                     {3,  7,  15},
//                                     {5,  12, 12},
//                                     {15, 20, 10},
//                                     {19, 24, 8}};

    // 这个例子说明必须使用multiset, 及存在重合且高度相等的矩形
    vector<vector<int>> buildings = {{0,  2,  3},
                                     {2,  5,  3}};
    OutputBasicArray2D1(Solution().getSkyline(buildings));

    return 0;
}
