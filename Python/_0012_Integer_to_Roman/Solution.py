# coding=utf-8


class Solution:
    def intToRoman(self, num: int) -> str:
        values = [
            1000,
            900, 500, 400, 100,
            90, 50, 40, 10,
            9, 5, 4, 1
        ]
        reps = [
            "M",
            "CM", "D", "CD", "C",
            "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"
        ]
        res = ""
        for i in range(len(values)):
            while num >= values[i]:
                num -= values[i]
                res += reps[i]
        return res


if __name__ == "__main__":
    print(Solution().intToRoman(1994))  # MCMXCIV
