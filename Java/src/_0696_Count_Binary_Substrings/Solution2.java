package _0696_Count_Binary_Substrings;

class Solution2 {
    public int countBinarySubstrings(String s) {

        int res = 0;
        int[] count = new int[2];
        char prev = '2';
        for(char c : s.toCharArray()) {
            int index = c-'0';
            if(c != prev) {
                prev = c;
                count[index] = 0;
            }

            count[index]++;
            if(count[1 - index] >= count[index]){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println((new Solution2()).countBinarySubstrings("00110011"));
    }
}
