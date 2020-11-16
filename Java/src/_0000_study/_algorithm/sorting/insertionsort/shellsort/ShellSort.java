package _0000_study._algorithm.sorting.insertionsort.shellsort;

import _0000_study._algorithm.sorting.SortTestHelper;

/**
 * Date: 2020/11/16 16:45
 * Content:
 */
public class ShellSort {

    // 我们的算法类不允许产生任何实例
    private ShellSort() {

    }

    //排序函数
    public static void shellSort(Comparable[] arr, int d) {

        final int size = arr.length;
        int i, j;
        for (i = d; i < size; i++) {  // d, 2d, 3d, ...
            if (arr[i - d].compareTo(arr[i]) > 0) {
                Comparable e = arr[i];
                arr[i] = arr[i - d];
                for (j = i - 2 * d; j >= 0 && arr[j].compareTo(e) > 0; j = j - d) {
                    arr[j + d] = arr[j];
                }
                arr[j + d] = e;
            }
        }
    }

    public static void shellSort(Comparable[] arr, int[] d) {

        for (int step : d) {
            shellSort(arr, step);
        }
    }

    public static void sort(Comparable[] arr) {

        int[] d = {5, 3, 1};
        shellSort(arr, d);
    }

    public static void main(String[] args) {
        String sortClassName = SortTestHelper.packagePrefix +
                ".insertionsort.shellsort.ShellSort";

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort(sortClassName, arr);
//        SortTestHelper.printArray(arr);
    }

}

/*
    //迭代器输出
    public void traverseByIterator() {
        long startTime = System.nanoTime();

        Iterator<Double> iterator = arr.iterator();
        while (iterator.hasNext()) {
            Double value = (Double) (iterator.next());
            System.out.println(value);
        }

        System.out.println("===========traverseByIterator===========");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration + "纳秒");
    }
 */
