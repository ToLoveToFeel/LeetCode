# coding=utf-8
# Date: 2021/8/1 11:20
from typing import List


# 执行用时：44 ms, 在所有 Python3 提交中击败了61.98%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了37.23%的用户
class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stk = []
        j = 0
        for i in range(len(pushed)):
            stk.append(pushed[i])
            while len(stk) != 0 and stk[len(stk) - 1] == popped[j]:
                stk.pop(len(stk) - 1)
                j += 1
        return len(stk) == 0


if __name__ == "__main__":
    pushed = [1, 2, 3, 4, 5]
    popped = [4, 5, 3, 2, 1]
    print(Solution().validateStackSequences(pushed, popped))  # True
