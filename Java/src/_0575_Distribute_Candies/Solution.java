package _0575_Distribute_Candies;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 2020/10/13 9:47
 * Content:
 * 哈希表
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        int num = candies.length / 2;  // 弟弟和妹妹应该获得的糖果的数目

        for (int candy : candies) {
            if (set.size() >= num)
                break;
            set.add(candy);
        }

        return set.size();
    }

    public static void main(String[] args) {
//        int[] candies = {1, 1, 2, 2, 3, 3};
        int[] candies = {1, 1, 2, 3};
        System.out.println((new Solution()).distributeCandies(candies));
    }
}
