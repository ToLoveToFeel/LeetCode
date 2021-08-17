package _0551_Student_Attendance_Record_I;

/**
 * Date: 2020/11/4 16:04
 * Content:
 * 执行用时：
 * 1 ms, 在所有 Java 提交中击败了52.84%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了82.95%的用户
 */
public class Solution {

    public static final Character ABSENT = 'A';  // 缺勤
    public static final Character LATE = 'L';  // 迟到
    public static final Character PRESENT = 'P';  // 到场

    public boolean checkRecord(String s) {
        if (s.length() <= 1)
            return true;

        int a = 0;  // 记录缺勤的次数
        int l = 0;  // 记录连续迟到的次数
        for (char c : s.toCharArray()) {
            if (c == ABSENT) {
                a++;
                if (a >= 2) return false;
                l = 0;
            } else if (c == LATE) {
                if (l >= 2) return false;
                l++;
            } else {  // c == PRESENT
                l = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        String s = "PPALLP";
//        System.out.println((new Solution()).checkRecord(s));  // true
        String s = "PPALLL";
        System.out.println((new Solution()).checkRecord(s));  // false
    }
}
