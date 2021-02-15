// Created by WXX on 2021/2/2 20:25
#include <iostream>

using namespace std;

// 约瑟夫问题
// https://www.acwing.com/video/1776/  20:00
/*
 * 假设一共n个数据，如果从左测开始删除最终剩余的数记为f(n)，从右侧开始删除最终剩余的数记为g(n)
 * 求f(n)的第一趟(1~n中删除所有奇数)：2 4 6 8 ... 。将2 4 6 8 ... 重新编号为1 2 3 4 ... ，
 * 则第二趟从右向左删除得到的数据为g(n/2)，所以有f(n)=2g(n/2)  ①
 * 因为f(n)和g(n)的求解是对称的，所以可以得到：f(n)+g(n)=n+1   ②
 * 结合①②，可知f(n) = 2g(n/2) = 2 * (n / 2 + 1 -f(n/2))
 */
/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了72.46%的用户
 * 内存消耗：5.8 MB, 在所有 C++ 提交中击败了86.64%的用户
 */
class Solution {
public:
    int lastRemaining(int n) {

        if (n == 1) return 1;
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
};

int main() {

    cout << Solution().lastRemaining(9) << endl;  // 6

    return 0;
}
