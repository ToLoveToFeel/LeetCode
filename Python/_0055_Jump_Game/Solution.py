# coding=utf-8
# @Time       : 2020/3/1
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode


class Solution(object):
    """
        1、构建一个list来存储每一个索引位置最远能走到的位置；
        2、遍历nums，如果元素的索引位置比当前最长能走到的位置远，说明这个索引位置就已经到达不了了。
    """
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        ls = []
        for index, num in enumerate(nums):
            ls.append(index+num)

        size = len(nums)

        longest = 0
        for index in range(size):
            if longest >= size - 1:
                break
            if index > longest:
                break
            longest = max(longest, ls[index])
        return longest >= size - 1


if __name__ == "__main__":
    So = Solution()
    print(So.canJump([2, 3, 1, 1, 4]))

