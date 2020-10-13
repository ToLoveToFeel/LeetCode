package _1103_Distribute_Candies_to_People;

/**
 * Date: 2020/10/13 9:16
 * Content:
 * 暴力法
 */
public class Solution2 {
    public int[] distributeCandies(int candies, int num_people) {
        if (num_people == 1)
            return new int[]{candies};

        int[] res = new int[num_people];
        int i = 0;
        while (candies > 0) {
            res[i % num_people] += Math.min(i + 1, candies);
            candies -= Math.min(i + 1, candies);
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int candies = 7, num_people = 4;
//        int candies = 10, num_people = 3;
//        int candies = 0, num_people = 3;
        int[] res = (new Solution2()).distributeCandies(candies, num_people);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
