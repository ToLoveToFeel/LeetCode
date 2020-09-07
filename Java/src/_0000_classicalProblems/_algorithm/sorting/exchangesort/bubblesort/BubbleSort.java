package _0000_classicalProblems._algorithm.sorting.exchangesort.bubblesort;

import _0000_classicalProblems._algorithm.sorting.SortTestHelper;

/**
 * Date: 2020/9/7 9:07
 * Content:
 */
public class BubbleSort {

    // 我们的算法类不允许产生任何实例
    private BubbleSort() {

    }

//    // 针对基本有序的数组，时间复杂度仍然是O(n^2)
//    public static void sort(Comparable[] arr) {
//
//        int n = arr.length;
//
//        for (int i = n - 1; i > 0; i--)
//            // 对[0...i]之间的数据进行交换
//            for (int j = 0; j < i; j++)
//                if (arr[j].compareTo(arr[j + 1]) > 0)
//                    swap(arr, j, j + 1);
//    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        boolean flag = false;  // 记录数组是否已经有序

        for (int i = n - 1; i > 0 && !flag; i--) {
            flag = true;
            // 对[0...i]之间的数据进行交换
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    // 测试 BubbleSort
    public static void main(String[] args) {
        String sortClassName = SortTestHelper.packagePrefix +
                ".exchangesort.bubblesort.BubbleSort";

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        SortTestHelper.testSort(sortClassName, arr);
//        SortTestHelper.printArray(arr);
    }
}
