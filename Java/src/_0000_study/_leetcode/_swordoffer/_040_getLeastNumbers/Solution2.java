package _0000_study._leetcode._swordoffer._040_getLeastNumbers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Date: 2020/12/5 15:29
 * Content: 使用快排中的partition解决
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了99.39%的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了66.35%的用户
 */
class Solution2 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0) return new int[0];

        selectK(arr, 0, arr.length - 1, k - 1);

        return Arrays.copyOf(arr, k);
    }

    private int selectK(int[] arr, int l, int r, int k) {

        int p = partition(arr, l, r);

        if (k == p)
            return arr[p];

        if (k < p)
            return selectK(arr, l, p - 1, k);

        return selectK(arr, p + 1, r, k);
    }

    private int partition(int[] arr, int l, int r) {

        // 生成 [l, r] 之间的随机索引
        int p = (int) (l + Math.random() * (r - l + 1));
        swap(arr, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i] < arr[l])
                i++;

            while (j >= i && arr[j] > arr[l])
                j--;

            if (i >= j) break;

            swap(arr, i, j);

            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

//        // [2, 1]
//        int[] arr = {3, 2, 1};
//        int k = 2;
        // [0]
        int[] arr = {0, 1, 2, 1};
        int k = 1;
        int[] res = (new Solution2()).getLeastNumbers(arr, k);

        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}

