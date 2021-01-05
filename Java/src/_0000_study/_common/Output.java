package _0000_study._common;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/10 9:51
 * Content: 用于输出各种格式的数据
 */
public class Output {

    public static void OutputBasicArray1D(int[] nums) {

        System.out.println(Arrays.toString(nums));
    }


    public static void OutputBasicArray2D(int[][] nums) {

        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                System.out.println(Arrays.toString(nums[i]) + ",");
            else if (i < nums.length - 1)
                System.out.println(" " + Arrays.toString(nums[i]) + ",");
            else
                System.out.print(" " + Arrays.toString(nums[i]));
        }
        System.out.print("]");
    }

    public static void OutputBasicArray2D(char[][] nums) {

        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                System.out.println(Arrays.toString(nums[i]) + ",");
            else if (i < nums.length - 1)
                System.out.println(" " + Arrays.toString(nums[i]) + ",");
            else
                System.out.print(" " + Arrays.toString(nums[i]));
        }
        System.out.print("]");
    }

    public static void OutputBasicArray2D1(int[][] nums) {

        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1)
                System.out.print(Arrays.toString(nums[i]) + ", ");
            else
                System.out.print(Arrays.toString(nums[i]));
        }
        System.out.print("]");
    }
}
