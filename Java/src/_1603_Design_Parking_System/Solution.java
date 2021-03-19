package _1603_Design_Parking_System;

/**
 * Created by WXX on 2021/3/19 14:49
 * 执行用时：10 ms, 在所有 Java 提交中击败了96.81%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了89.32%的用户
 */
public class Solution {

    static class ParkingSystem {

        int[] nums = new int[3];

        public ParkingSystem(int big, int medium, int small) {
            nums[0] = big;
            nums[1] = medium;
            nums[2] = small;
        }

        public boolean addCar(int carType) {
            carType--;
            if (nums[carType] != 0) {
                nums[carType]--;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

        ParkingSystem t = new ParkingSystem(1, 1, 0);
        System.out.println(t.addCar(1));  // true
        System.out.println(t.addCar(2));  // true
        System.out.println(t.addCar(3));  // false
        System.out.println(t.addCar(1));  // false
    }
}
