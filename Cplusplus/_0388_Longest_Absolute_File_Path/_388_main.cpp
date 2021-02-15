// Created by WXX on 2021/2/2 19:54
#include <iostream>
#include <stack>

using namespace std;

// 文件（文件夹也看成一种特殊的文件）的层次关系可以看成一棵树，假设树根位于第0层
/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：6.2 MB, 在所有 C++ 提交中击败了98.91%的用户
 */
class Solution {
public:
    int lengthLongestPath(string input) {

        stack<int> stk;  // 存储当前遍历的路径各个文件的长度
        int res = 0;
        for (int i = 0, sum = 0; i < input.size();) {
            int k = 0;  // 记录当前文件位于那一层
            while (i < input.size() && input[i] == '\t') i++, k++;
            while (stk.size() > k) sum -= stk.top(), stk.pop();  // 第k层此时应该保留k个数据
            // 计算下一个文件的长度
            int j = i;
            while (j < input.size() && input[j] != '\n') j++;
            int len = j - i;
            stk.push(len), sum += len;
            if (input.substr(i, len).find('.') != -1)
                res = max(res, sum + (int)stk.size() - 1);
            i = j + 1;  // +1是为了跳过'\n'
        }
        return res;
    }
};

int main() {

    cout << Solution().lengthLongestPath(
            "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext") << endl;  // 20

    cout << Solution().lengthLongestPath(
            "file1.txt\nfile2.txt\nlongfile.txt") << endl;  // 0

    cout << Solution().lengthLongestPath(
            "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1"
            "\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext") << endl;  // 32

    cout << Solution().lengthLongestPath("a") << endl;  // 0

    return 0;
}
