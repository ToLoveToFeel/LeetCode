# coding=utf-8
# Date: 2021/7/24 9:51


# 执行用时：28 ms, 在所有 Python3 提交中击败了97.49%的用户
# 内存消耗：15.1 MB, 在所有 Python3 提交中击败了5.03%的用户
class Solution:
    def maximumTime(self, time: str) -> str:
        t = list(time)
        if t[0] == '?' and t[1] == '?':
            t[0] = '2'
            t[1] = '3'
        elif t[0] == '?':
            if t[1] <= '3':
                t[0] = '2'
            else:
                t[0] = '1'
        elif t[1] == '?':
            if t[0] <= '1':
                t[1] = '9'
            else:
                t[1] = '3'
        # 处理分钟
        if t[3] == '?':
            t[3] = '5'
        if t[4] == '?':
            t[4] = '9'
        return "".join(t)


if __name__ == "__main__":
    print(Solution().maximumTime("2?:?0"))  # 23:50
    print(Solution().maximumTime("0?:3?"))  # 09:39
    print(Solution().maximumTime("1?:22"))  # 19:22
