package _0968_Binary_Tree_Cameras;

/**
 * Date: 2020/9/22 8:55
 * Content:
 * 该解法没有理解，所以没有完成，可以参 Solution2
 */
public class Solution {
    /*
    对于某个节点，有三种状态：
        State a: 已经安装了摄像头               √
        State b: 没有安装摄像头，但已被覆盖       △
        State c: 没有安装摄像头，但还未被覆盖     ○
    对于某个节点 node 而言，设其左右孩子分别是 left 和 right, 对应的状态分别是 (la, lb, lc), (ra, tb, rc)
            node √
           /   \        a = lb + rb
      △ left  right △
            node △
           /   \        b = min(1 + la + rb, lc + rc)     c = 1 + la + rb
      √ left  right ○
     */
    public int minCameraCover(TreeNode root) {
        return 0;
    }
}
