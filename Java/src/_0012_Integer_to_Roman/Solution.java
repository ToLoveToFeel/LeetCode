package _0012_Integer_to_Roman;

/**
 * Date: 2020/8/28 16:46
 * Content:
 */
class Solution {
    private StringBuilder toBaseRoman(int num) {
        // 参数num只能最高位非零，最大为3000
        Character[] chs = {
                'I', 'V', 'X',
                'X', 'L', 'C',
                'C', 'D', 'M',
                'M'
        };

        StringBuilder s = new StringBuilder();
        int length = 0;
        while (num >= 10) {
            length ++;
            num /= 10;
        }

        if (num <= 3) {
            for (int i = 0; i < num; i++)
                s.append(chs[3*length]);
        } else if (num == 4) {
            s.append(chs[3*length]);
            s.append(chs[3*length+1]);
        } else if (num <= 8) {
            s.append(chs[3*length+1]);
            for (int i = 0; i < num - 5; i++)
                s.append(chs[3*length]);
        } else { // num == 9
            s.append(chs[3*length]);
            s.append(chs[3*length+2]);
        }
        return s;
    }

    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();

        int order = 1;
        while (num != 0) {
            s.insert(0, toBaseRoman((num % 10) * order));
            num /= 10;
            order *= 10;
        }

        return s.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println((new Solution()).intToRoman(num));
    }
}
