package _1103_Distribute_Candies_to_People;

/**
 * Date: 2020/10/13 9:16
 * Content:
 */
public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        if (num_people == 1)
            return new int[]{candies};

        int[] res = new int[num_people];
        int first = 1;  // 记录每次第一个人应该发的糖果数目，如果足够的话，则最后一个人应该发的糖果数目为 first+num_people-1
        int count = 0;  // 记录能完整发糖的次数
        while (true) {
            int sum = (first + (first + num_people - 1)) * num_people / 2;  // 等差数列求和
            if (sum > candies)
                break;
            first += num_people;
            candies -= sum;
            count++;
        }

        // 一次性将这些完整轮次发糖发给大家
        res[0] = (1 + (1 + (count - 1) * num_people)) * count / 2;  // 等差数列求和，首项1，尾项 1+(count-1)*num_people
        for (int i = 1; i < num_people; i++) {
            res[i] = res[i-1] + count;
        }

        // 将剩余的糖果从头分给各人，不够分完整一轮
        int i = 0;
        int num = first;
        while (candies > 0) {
            res[i] += Math.min(candies, num);
            candies -= num;
            num += 1;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
//        int candies = 7, num_people = 4;
//        int candies = 10, num_people = 3;
        int candies = 0, num_people = 3;
        int[] res = (new Solution()).distributeCandies(candies, num_people);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
