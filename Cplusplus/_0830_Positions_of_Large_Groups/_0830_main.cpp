#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了90.54%的用户
 * 内存消耗：7.5 MB, 在所有 C++ 提交中击败了81.91%的用户
 */
class Solution {
public:
    vector<vector<int>> largeGroupPositions(string s) {

        vector<vector<int>> res;
        for (int i = 1, j = 0, cnt = 1; i < s.size(); i++) {
            while (i < s.size() && s[i] == s[j]) i++, cnt++;
            if (cnt >= 3) res.push_back({j, j + cnt - 1});
            j = i;
            cnt = 1;
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

    vector<vector<int>> res = Solution().largeGroupPositions("abbxxxxzzy");
    OutputBasicArray2D1(res);
    res = Solution().largeGroupPositions("abc");
    OutputBasicArray2D1(res);
    res = Solution().largeGroupPositions("abcdddeeeeaabbbcd");
    OutputBasicArray2D1(res);

    return 0;
}
