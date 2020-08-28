package _0013_Roman_to_Integer;

/**
 * Date: 2020/8/28 16:11
 * Content:
 */
class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int index = 0;
        int length = s.length();
        while (index < length) {
            switch (s.charAt(index)) {
                // IV 4     IX 9
                case 'I':
                    if (index + 1 < length) {
                        if (s.charAt(index + 1) == 'V') {
                            num += 4;
                            index++;
                        } else if (s.charAt(index + 1) == 'X') {
                            num += 9;
                            index++;
                        } else
                            num += 1;
                    } else
                        num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                // XL 40    XC 90
                case 'X':
                    if (index + 1 < length) {
                        if (s.charAt(index + 1) == 'L') {
                            num += 40;
                            index++;
                        } else if (s.charAt(index + 1) == 'C') {
                            num += 90;
                            index++;
                        } else
                            num += 10;
                    } else
                        num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                // CD 400   CM 900
                case 'C':
                    if (index + 1 < length) {
                        if (s.charAt(index + 1) == 'D') {
                            num += 400;
                            index++;
                        } else if (s.charAt(index + 1) == 'M') {
                            num += 900;
                            index++;
                        } else
                            num += 100;
                    } else
                        num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
            index++;
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "III";
        System.out.println((new Solution()).romanToInt(s));
    }
}
