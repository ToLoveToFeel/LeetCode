# coding=utf-8


# 执行用时：36 ms, 在所有 Python3 提交中击败了86.85%的用户
# 内存消耗：14.9 MB, 在所有 Python3 提交中击败了68.96%的用户
class Solution:
    def isValid(self, s: str) -> bool:
        stk = []
        for c in s:
            if c == '(' or c == '[' or c == '{':
                stk.append(c)
            else:
                if len(stk) > 0 and abs(ord(stk[len(stk) - 1]) - ord(c)) <= 2:
                    stk.pop(len(stk) - 1)
                else:
                    return False
        return len(stk) == 0


if __name__ == "__main__":
    print(Solution().isValid("(){}[]"))  # True
    print(Solution().isValid("([)]"))  # False
