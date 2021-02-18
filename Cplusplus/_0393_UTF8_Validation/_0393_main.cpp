// Created by WXX on 2021/2/2 20:55
#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了70.56%的用户
 * 内存消耗：13.2 MB, 在所有 C++ 提交中击败了81.30%的用户
 */
class Solution {
public:

    int get(int x, int k) {
        return x >> k & 1;
    }

    bool validUtf8(vector<int>& data) {

        for (int i = 0; i < data.size(); i++) {
            if (!get(data[i], 7)) continue;
            int k = 0;  // 获取表示整个字符的所有字节数目
            while (k <= 4 && get(data[i], 7 - k)) k++;
            if (k == 1 || k > 4) return false;
            for (int j = 0; j < k - 1; j++) {
                int t = i + 1 + j;
                if (t >= data.size()) return false;  // 说明最后一个字符不完整
                if (!(get(data[t], 7) && !get(data[t], 6))) return false;
            }
            i += k - 1;
        }
        return true;
    }
};

int main() {

    vector<int> data = {197, 130, 1};
    cout << Solution().validUtf8(data) << endl;  // true

    return 0;
}
