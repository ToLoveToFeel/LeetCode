package _0220_Contains_Duplicate_III;

import java.util.HashMap;

/**
 * 每次基于存储桶，我们需要检查的是x所属的存储桶及其两个相邻的存储桶。值得一提的是与存储桶排序的区别–
 * 我们的每个存储桶在任何时候最多都包含一个元素，因为两个元素在存储桶中表示“几乎重复”，我们可以从函数
 * 中尽早返回。因此，具有与存储桶标签关联的元素的HashMap足以满足我们的目的。
 * https://leetcode-cn.com/problems/contains-duplicate-iii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-46/
 * 时间复杂度：O(n)
 * 空间复杂度：O(k)
 * <p>
 * 执行用时：21 ms, 在所有 Java 提交中击败了83.51%的用户
 * 内存消耗：41.3 MB, 在所有 Java 提交中击败了20.81%的用户
 */
public class Solution2 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        HashMap<Long, Long> buckets = new HashMap<>();
        long w = (long) t + (long) 1;  // 一个桶里边数字范围的个数是 t + 1
        // id=-1 对应 [-w...-1]
        // id=0 对应 [0...w-1]
        // id=1 对应 [w...2w-1]

        for (int i = 0; i < nums.length; i++) {

            long num = nums[i];
            long id = getID(num, w);
            // 检查编号为id的桶是否为空，每个桶最多有一个元素，如果存在两个元素的话，直接返回 true
            if (buckets.containsKey(id)) return true;
            // 检查相邻的两个桶
            if (buckets.containsKey(id - 1) && buckets.get(id - 1) >= num - (long) t) return true;
            if (buckets.containsKey(id + 1) && buckets.get(id + 1) <= num + (long) t) return true;
            // 此时说明，编号为id的桶为空，并且相邻的两个桶也满足条件
            buckets.put(id, num);
            if (buckets.size() == k + 1) buckets.remove(getID(nums[i - k], w));
        }
        return false;
    }

    // 桶宽度为w，获取元素 x 的 id
    // 因为 -3 / 4 = 0, 但是我们需要 -3 / 4 = -1
    private long getID(long x, long w) {

        // num 加 1, 把负数移动到从 0 开始, 这样算出来标号最小是 0, 已经用过了, 所以要再减 1
        // 如果 w=4,则0,1,2,3落到 0号桶中；-4，-3，-2，-1落到-1号桶中
        // (-4 + 1) / 4 - 1 = -1
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public static void main(String[] args) {

        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        System.out.println((new Solution2()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}
