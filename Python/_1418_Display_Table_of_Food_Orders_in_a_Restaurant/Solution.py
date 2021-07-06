# coding=utf-8
# Date: 2021/7/6 15:20
from typing import List
from sortedcontainers import SortedSet
from sortedcontainers import SortedDict


# 执行用时：508 ms, 在所有 Python3 提交中击败了41.07%的用户
# 内存消耗：25.5 MB, 在所有 Python3 提交中击败了71.43%的用户
class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        foodList = SortedSet()
        tableList = SortedDict()
        for e in orders:
            foodList.add(e[2])
            id = int(e[1])
            if id not in tableList:
                tableList[id] = SortedDict()
            if e[2] not in tableList[id]:
                tableList[id][e[2]] = 0
            tableList[id][e[2]] += 1

        res = []
        title = ["Table"]
        for e in foodList:
            title.append(e)
        res.append(title)
        for k, v in tableList.items():  # k:餐桌编号, v:餐桌上的食物及其数量
            t = [str(k)]
            for e in foodList:
                if e not in v:
                    t.append("0")
                else:
                    t.append(str(v[e]))
            res.append(t)
        return res


if __name__ == "__main__":
    orders = [
        ["David", "3", "Ceviche"],
        ["Corina", "10", "Beef Burrito"],
        ["David", "3", "Fried Chicken"],
        ["Carla", "5", "Water"],
        ["Carla", "5", "Ceviche"], 
        ["Rous", "3", "Ceviche"]
    ]
    print(Solution().displayTable(orders))
