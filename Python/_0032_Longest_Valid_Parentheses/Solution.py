# coding=utf-8
# Date: 2021/5/21 21:30


# 执行用时：64 ms, 在所有 Python3 提交中击败了24.61%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了69.49%的用户
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stk = []
        start = -1
        res = 0
        for i in range(len(s)):
            if s[i] == '(':
                stk.append(i)
            else:
                if len(stk) != 0:
                    stk.pop(len(stk) - 1)
                    if len(stk) != 0:
                        res = max(res, i - stk[len(stk) - 1])
                    else:
                        res = max(res, i - start)
                else:
                    start = i
        return res


if __name__ == "__main__":
    print(Solution().longestValidParentheses("(()"))  # 2
