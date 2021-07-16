// Created by WXX on 2021/2/28 13:41
#include "MyTree.h"
#include <stack>

/**
 * 执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
 * 内存消耗：8.1 MB, 在所有 C++ 提交中击败了79.83%的用户
 */
// Morris
/**
 * 从根节点开始遍历，直至当前节点为空为止：
 * (1) 如果当前节点没有左儿子，则**打印当前节点的值**，然后进入右子树；
 * (2) 如果当前节点有左儿子，则找当前节点的前驱(中序遍历意义下的前驱)。
 * 	(2.1) 如果前驱节点的右儿子为空，说明左子树没遍历过，将前驱节点的右儿子置成当前节点，方便回溯，**打印当前节点的值**，然后进入左子树遍历；
 * 	(2.2) 如果前驱节点的右儿子为当前节点，说明左子树已被遍历过，则将前驱节点的右儿子恢复为空，然后进入右子树继续遍历；
 */
class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> res;
        while (root) {
            if (!root->left) {  // (1)
                res.push_back(root->val);
                root = root->right;
            } else {  // (2)
                TreeNode *p = root->left;
                while (p->right && p->right != root) p = p->right;  // 第二个条件是因可可能是第二次遍历root的前驱

                if (!p->right) {  // (2.1)
                    p->right = root;  // root的前驱节点p的右孩子指向root, 方便回溯
                    res.push_back(root->val);  // 和中序遍历的唯一区别
                    root = root->left;
                } else {  // (2.2)
                    p->right = NULL;  // 恢复原状
                    root = root->right;
                }
            }
        }
        return res;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            1,
            nu, 2,
            nu, nu, 3
    };
    TreeNode *root = MyTree(nums).getRoot();
    OutputBasicArray1D(Solution().preorderTraversal(root));

    return 0;
}
