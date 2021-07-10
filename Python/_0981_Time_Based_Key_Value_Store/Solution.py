# coding=utf-8
# Date: 2021/7/10 16:55


# 执行用时：396 ms, 在所有 Python3 提交中击败了100.00%的用户
# 内存消耗：66.9 MB, 在所有 Python3 提交中击败了93.88%的用户
class TimeMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hash_time = {}
        self.hash_value = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.hash_time:
            self.hash_time[key] = []
        if key not in self.hash_value:
            self.hash_value[key] = []
        self.hash_time[key].append(timestamp)
        self.hash_value[key].append(value)

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.hash_time or timestamp < self.hash_time[key][0]:
            return ""
        t = self.hash_time[key]
        if timestamp >= t[len(t) - 1]:
            return self.hash_value[key][len(t) - 1]

        l, r = 0, len(t) - 1
        while l < r:
            mid = l + r + 1 >> 1
            if t[mid] <= timestamp:
                l = mid
            else:
                r = mid - 1
        return self.hash_value[key][r]


if __name__ == "__main__":
    t = TimeMap()
    t.set("a", "bar", 1)
    t.set("x", "b", 3)
    print(t.get("b", 3))
    t.set("foo", "bar2", 4)
    print(t.get("foo", 4))
    print(t.get("foo", 5))
