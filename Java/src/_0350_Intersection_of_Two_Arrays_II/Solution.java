package _0350_Intersection_of_Two_Arrays_II;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> comSet = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int val:nums1) {
            if(!comSet.containsKey(val))
                comSet.put(val, 1);
            else
                comSet.put(val, comSet.get(val)+1);
        }
        for (int val:nums2) {
            if(comSet.containsKey(val)) {
                arrayList.add(val);
                comSet.put(val, comSet.get(val) - 1);
                if (0 == comSet.get(val))
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
        int[] ret = (new Solution()).intersect(nums1, nums2);
        for (int val:ret)
            System.out.println(val);
    }
}
