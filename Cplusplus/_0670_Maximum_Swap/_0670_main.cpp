// Created by WXX on 2021/3/2 15:56
#include <iostream>

using namespace std;

// 思路：找到第一个相邻的升序对，然后
class Solution {
public:
    int maximumSwap(int num) {
        string str = to_string(num);
        for (int i = 0; i + 1 < str.size(); i++) {
            if (str[i] < str[i + 1]) {
                int k = i + 1;
                for (int j = k; j < str.size(); j++)
                    if (str[j] > str[k])
                        k = j;
                    for (int j = 0; ; j++)
                        if (str[j] < str[k]) {
                            swap(str[j], str[k]);
                            return stoi(str);
                        }
            }
        }
        return num;  // 说明非增
    }
};

int main() {

    cout << Solution().maximumSwap(2736) << endl;  // 7236
    cout << Solution().maximumSwap(9973) << endl;  // 9973

    return 0;
}
