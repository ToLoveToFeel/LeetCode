// Created by WXX on 2021/4/24 20:05
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    string multiply(string num1, string num2) {

        vector<int> A, B;
        int n = num1.size(), m = num2.size();
        for (int i = n - 1; i >= 0; i--) A.push_back(num1[i] - '0');
        for (int i = m - 1; i >= 0; i--) B.push_back(num2[i] - '0');

        // (1) 不考虑进位，将结果存入C中
        vector<int> C(n + m);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                C[i + j] += A[i] * B[j];
        // (2) 考虑进位
        for (int i = 0, t = 0; i < C.size(); i++) {
            t += C[i];
            C[i] = t % 10;
            t /= 10;
        }

        // 处理输出
        int k = C.size() - 1;
        while (k && C[k] == 0) k--;
        string res;
        while (k >= 0) res += C[k--] + '0';
        return res;
    }
};

int main() {

    cout << Solution().multiply("123", "456") << endl;

    return 0;
}
