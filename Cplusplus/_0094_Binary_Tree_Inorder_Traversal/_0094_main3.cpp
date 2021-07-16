// Created by WXX on 2021/2/28 14:05
#include "MyTree.h"
#include <stack>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了41.93%的用户
 * 内存消耗：8.2 MB, 在所有 C++ 提交中击败了31.45%的用户
 */
// Morris
/**
 * 从根节点开始遍历，直至当前节点为空为止：
 * (1) 如果当前节点没有左儿子，则打印当前节点的值，然后进入右子树；
 * (2) 如果当前节点有左儿子，则找当前节点的前驱。
 * 	(2.1) 如果前驱节点的右儿子为空，说明左子树没遍历过，则进入左子树遍历，并将前驱节点的右儿子置成当前节点，方便回溯；
 * 	(2.2) 如果前驱节点的右儿子为当前节点，说明左子树已被遍历过，则将前驱节点的右儿子恢复为空，然后打印当前节点的值，然后进入右子树继续遍历；
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
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
                    root = root->left;
                } else {  // (2.2)
                    p->right = NULL;  // 恢复原状
                    res.push_back(root->val);  // root的左孩子已经遍历完毕，遍历当前节点
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
    vector<int> res = Solution().inorderTraversal(root);
    OutputBasicArray1D(res);

    return 0;
}
