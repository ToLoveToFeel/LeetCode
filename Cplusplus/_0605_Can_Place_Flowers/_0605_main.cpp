#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时40 m, 在所有 C++ 提交中击败66.89的用户
 * 内存消耗：20.1 MB, 在所有 C++ 提交中击败了50.67%的用户
 */
class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {

        int len = flowerbed.size();
        if (len == 1 && flowerbed[0] == 0) return n <= 1;

        int cnt = 0;
        // 处理前两个数据
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            cnt++;
        }
        // 处理中间的数据
        for (int i = 1; i < len - 2; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                cnt++;
            }
        }
        // 处理最后两个数据
        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            flowerbed[len - 1] = 1;
            cnt++;
        }

        return cnt >= n;
    }
};


int main() {

    vector<int> flowerbed = {0, 0, 1, 0, 1};
    int n = 1;
    cout << Solution().canPlaceFlowers(flowerbed, n) << endl;

    return 0;
}

