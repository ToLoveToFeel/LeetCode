// Created by WXX on 2021/7/6 14:46
#include <iostream>
#include <vector>
#include <set>
#include <map>

using namespace std;

class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>> &orders) {
        set<string> foodList;  // 用于记录表头
        map<int, map<string, int>> tableList;  // 餐桌对应的食物数量
        for (auto &e : orders) {
            foodList.insert(e[2]);  // 食物名称
            tableList[stoi(e[1])][e[2]]++;  // 餐桌e[1]对应的食物e[2]数量加一
        }

        vector<vector<string>> res;
        vector<string> title = {"Table"};
        for (auto &s : foodList) title.push_back(s);

        res.push_back(title);
        for (auto &p : tableList) {
            vector<string> t = {to_string(p.first)};
            for (auto &s : foodList) t.push_back(to_string(p.second[s]));
            res.push_back(t);
        }
        return res;
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

    vector<vector<string>> orders = {
            {"David",  "3",  "Ceviche"},
            {"Corina", "10", "Beef Burrito"},
            {"David",  "3",  "Fried Chicken"},
            {"Carla",  "5",  "Water"},
            {"Carla",  "5",  "Ceviche"},
            {"Rous",   "3",  "Ceviche"},
    };
    OutputBasicArray2D(Solution().displayTable(orders));

    return 0;
}
