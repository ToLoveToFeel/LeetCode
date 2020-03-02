# coding=utf-8
# @Time       : 2020/3/2
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode


class Solution(object):
    """
        1、首先对列表中的元素基于第一个元素排序；
        2、遍历列表，如果其中的元素对的右节点比下一个元素对的左节点大，则代表上下两个元素对是重叠的，
           递归的执行这个过程，找到所有的重叠部分
    """
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]，可能为[]
        :rtype: List[List[int]]
        """
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
        [1, 3],
        [2, 6],
        [8, 10],
        [15, 18]
    ]
    So = Solution()
    print(So.merge(intervals))


