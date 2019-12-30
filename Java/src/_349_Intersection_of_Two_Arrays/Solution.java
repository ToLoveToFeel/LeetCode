package _349_Intersection_of_Two_Arrays;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> comSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int val:nums1) {
            comSet.add(val);
        }
        for (int val:nums2) {
            if(comSet.contains(val)) {
                arrayList.add(val);
                comSet.remove(val);
            }
        }
        int[] ret = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ret[i] = arrayList.get(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1,3,3};
        int[] nums2 = new int[]{2,3,2};
        int[] ret = (new Solution()).intersection(nums1, nums2);
        for (int val:ret)
            System.out.println(val);
    }
}
