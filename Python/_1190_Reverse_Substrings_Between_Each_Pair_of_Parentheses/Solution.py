# coding=utf-8
# Date: 2021/5/26 10:28
from typing import List


class Solution:
    def reverseParentheses(self, s: str) -> str:
        stk = []
        res = ""
        for c in s:
            if c == '(':
                stk.append(res)
                res = ""
            elif c == ')':
                res = stk[len(stk) - 1] + res[::-1]
                stk.pop(len(stk) - 1)
            else:
                res += c
        return res


if __name__ == "__main__":
    print(Solution().reverseParentheses("(u(love)i)"))
    print(Solution().reverseParentheses("(a(bc(def)g)h)"))
    print(Solution().reverseParentheses("a(bcdefghijkl(mno)p)q"))
