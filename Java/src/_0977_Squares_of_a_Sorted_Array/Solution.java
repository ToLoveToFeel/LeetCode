package _0977_Squares_of_a_Sorted_Array;

/**
 * Date: 2020/10/16 10:52
 * Content:
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        // 处理全为非负的情况
        if (A[0] >= 0) {
            for (int i = 0; i < A.length; i++)
                res[i] = A[i] * A[i];
        } else if (A[A.length - 1] <= 0) {  // 处理全为非正的情况
            for (int i = A.length - 1; i >= 0; i--)
                res[A.length - 1 - i] = A[i] * A[i];
        } else {  // 说明数组中既存在负数，也存在正数
            // 第一步，寻找正负数的分界点 p：A[0...p] <= 0   A(p...A.length) >= 0，一定能找到
            int p = 0;
            int l = 0, r = A.length - 1;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (A[mid] <= 0 && A[mid + 1] >= 0) {
                    p = mid;
                    break;
                }

                if (A[mid] > 0)
                    r = mid;
                else if (A[mid + 1] < 0)
                    l = mid;
            }
            // 第二步：数组元素平方
            for (int i = 0; i < A.length; i++) {
                A[i] = A[i] * A[i];
            }
            // 第三步：归并排序，对数组reverse(A[0...p])和A(p...A.length)进行归并
            int i = p, j = p + 1;
            for (int k = 0; k < A.length; k++) {
                if (i < 0) {  // 左半边结束
                    res[k] = A[j++];
                } else if (j >= A.length) {  // 右半边结束
                    res[k] = A[i--];
                } else if (A[i] < A[j]) {  // 均为结束，且A[i] < A[j]
                    res[k] = A[i];
                    i--;
                } else {  // // 均为结束，且A[i] >= A[j]
                    res[k] = A[j];
                    j++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] A = {-4, -1, 0, 3, 10};
        int[] A = {-7, -3, 2, 3, 11};
        int[] res = (new Solution()).sortedSquares(A);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
