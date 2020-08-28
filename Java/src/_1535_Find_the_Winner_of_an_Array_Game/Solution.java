package _1535_Find_the_Winner_of_an_Array_Game;


/**
 * Date: 2020/8/28 21:22
 * Content:
 */
class Solution {
    private int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public int getWinner(int[] arr, int k) {
        if (k >= arr.length - 1)
            return findMax(arr);

        int prevMax = Math.max(arr[0], arr[1]);
        if (k == 1)
            return prevMax;
        int winCount = 1;  // 赢的次数
        for (int i = 2; i < arr.length; i++) {
            int cur = arr[i];
            if (prevMax > cur){
                winCount ++;
                if (winCount == k)
                    return prevMax;
            } else {
                prevMax = cur;
                winCount = 1;
            }
        }
        return prevMax;
    }

    public static void main(String[] args) {
        int[] arr = {1,9,8,2,3,7,6,4,5};
        int k = 7;
        System.out.println((new Solution()).getWinner(arr, k));
    }
}
