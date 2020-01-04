package _0447_Number_of_Boomerangs;

class Solution {
    // 时间复杂度：O(n^3)
    // Time Limit Exceeded
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points.length; j++)
                for (int k = 0; k < points.length; k++){
                    if (i != j && i != k && j != k){
                        if (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2) ==
                                Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2)) {
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