package _0021_Merge_Two_Sorted_Lists;

/**
 * Date: 2020/8/29 20:10
 * Content:
 */
public class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        else if (l1.val < l2.val) { // 递归
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
