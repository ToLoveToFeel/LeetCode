package _0109_Convert_Sorted_List_to_Binary_Search_Tree;

/**
 * Date: 2020/10/2 9:39
 * Content:
 * 中序遍历：比 Solution 效率高
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/shou-hua-tu-jie-san-chong-jie-fa-jie-zhu-shu-zu-ku/
 * 方法3
 */
public class Solution2 {

    ListNode head;
    int size;  // 链表元素个数

    private TreeNode sortedListToBST(int start, int end) {

        if (start > end) return null;

        int mid = (end - start) / 2 + start;

        // 创建左子树
        TreeNode leftNode = sortedListToBST(start, mid - 1);
        // 创建根节点
        TreeNode root = new TreeNode(head.val);
        head = head.next;  // 指针后移，为创建右子树做准备
        root.left = leftNode;
        // 创建右节点
        root.right = sortedListToBST(mid + 1, end);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        while (head != null) {
            size++;
            head = head.next;
        }

        return sortedListToBST(0, size - 1);
    }

    public static void main(String[] args) {

        ListNode head = (new MyLinkedList(new int[]{-10, -3, 0, 5, 9})).getHead();
        TreeNode root = (new Solution2()).sortedListToBST(head);
        System.out.println(MyTree.levelOrder(root));
    }
}
