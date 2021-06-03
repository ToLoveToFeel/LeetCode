package _0447_Number_of_Boomerangs;

class Solution {
    // 时间复杂度：O(n^3)
    // Time Limit Exceeded
    public int numberOfBoomerangs(int[][] p) {

        int res = 0;
        for (int i = 0; i < p.length; i++)
            for (int j = 0; j < p.length; j++)
                for (int k = 0; k < p.length; k++){
                    if (i != j && i != k && j != k){
                        if (Math.pow(p[i][0] - p[j][0], 2) + Math.pow(p[i][1] - p[j][1], 2) ==
                                Math.pow(p[i][0] - p[k][0], 2) + Math.pow(p[i][1] - p[k][1], 2)) {
                            res++;
                        }
                    }
                }
        return res;
    }

    public static void main(String[] args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new Solution()).numberOfBoomerangs(points));
    }
}