# coding=utf-8
# @Time       : 2020/3/4
# @Author     : Wang Xiaoxiao
# @University : Dalian University of Technology
# @FileName   : Solution.py
# @Software   : PyCharm
# @github     : https://github.com/i-love-linux/LeetCode
# 最后一个单词长度


class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()  # 删除前后空格

        size = len(s)
        count = 0
        while size-1-count >= 0 and s[size-1-count] != " ":
            count += 1

        return count


if __name__ == "__main__":

    So = Solution()
    print(So.lengthOfLastWord("Hello World"))

