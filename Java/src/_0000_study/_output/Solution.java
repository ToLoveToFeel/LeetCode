package _0000_study._output;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/11/10 9:51
 * Content: 用于输出各种格式的数据
 */
public class Solution {

    @Test
    public void OutputBasicArray1D() {

//        int[] nums = {1, 2, 3, 4, 5};
        double[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    @Test
    public void OutputBasicArray2D() {

        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                System.out.println(Arrays.stream(nums[i]).boxed().collect(Collectors.toList()) + ",");
            else if (i < nums.length - 1)
                System.out.println(" " + Arrays.stream(nums[i]).boxed().collect(Collectors.toList()) + ",");
            else
                System.out.print(" " + Arrays.stream(nums[i]).boxed().collect(Collectors.toList()));
        }
        System.out.print("]");
    }

    @Test
    public void OutputBasicArray2D1() {

        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1)
                System.out.print(Arrays.stream(nums[i]).boxed().collect(Collectors.toList()) + ", ");
            else
                System.out.print(Arrays.stream(nums[i]).boxed().collect(Collectors.toList()));
        }
        System.out.print("]");
    }
}
