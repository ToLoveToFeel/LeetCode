# coding=utf-8
# @Time       : 2020/3/3
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode
# 插入区间


class Solution(object):
    """
    1、将新元素插入数组，然后对列表中的元素基于第一个元素排序；
    2、遍历列表，如果其中的元素对的右节点比下一个元素对的左节点大，则代表上下两个元素对
       是重叠的，重复的执行这个过程，找到所有的重叠部分；
    3、这道题和上一道类似，不过需要在最开始把新插入的区间放到列表中即可
    """
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        intervals.append(newInterval)
        intervals.sort(key=lambda x: x[0])
        ret = []
        i = 0
        while i < len(intervals):
            left = intervals[i][0]
            right = intervals[i][1]

            while i+1 < len(intervals) and intervals[i+1][0] <= right:
                right = max(right, intervals[i+1][1])
                i += 1
            ret.append([left, right])
            i += 1
        return ret


if __name__ == "__main__":
    intervals = [
        [1, 2],
        [3, 5],
        [6, 7],
        [8, 10],
        [12, 16]
    ]
    newInterval = [4, 8]
    So = Solution()
    print(So.insert(intervals, newInterval))


