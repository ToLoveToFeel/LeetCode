// Created by WXX on 2021/6/3 19:23
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int numberOfBoomerangs(vector<vector<int>> &p) {
        int res = 0;
        for (int i = 0; i < p.size(); i++) {
            unordered_map<int, int> hash;
            for (int j = 0; j < p.size(); j++)
                if (i != j) {
                    int dx = p[i][0] - p[j][0], dy = p[i][1] - p[j][1];
                    int d = dx * dx + dy * dy;
                    hash[d]++;
                }
            for (auto &[k, v] : hash) res += v * (v - 1);
        }
        return res;
    }
};

int main() {

    vector<vector<int>> p = {{0, 0}, {1, 0}, {2, 0}};
    cout << Solution().numberOfBoomerangs(p) << endl;  // 2


    return 0;
}
