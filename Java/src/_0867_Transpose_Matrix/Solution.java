package _0867_Transpose_Matrix;

/**
 * Date: 2020/8/28 20:58
 * Content:
 */
class Solution {
    private void swap(int[][] A, int i, int j) {
        int temp = A[i][j];
        A[i][j] = A[j][i];
        A[j][i] = temp;
    }

    public int[][] transpose(int[][] A) {
        int[][] transpose = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        int[][] A = {
            {1,2,3},
            {4,5,6},
        };
        int[][] transpose = (new Solution()).transpose(A);
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }
}
