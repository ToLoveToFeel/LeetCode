#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了82.96%的用户
 * 内存消耗：9.1 MB, 在所有 C++ 提交中击败了72.72%的用户
 */
class Solution {
public:
    void merge(vector<int> &nums1, int m, vector<int> &nums2, int n) {

        m--, n--;
        for (int i = nums1.size() - 1; i >= 0; i--) {
            if (n < 0) nums1[i] = nums1[m--];
            else if (m < 0) nums1[i] = nums2[n--];
            else if (nums1[m] >= nums2[n]) nums1[i] = nums1[m--];
            else nums1[i] = nums2[n--];
        }
    }
};

int main() {

//    vector<int> nums1 = {1, 2, 3, 0, 0, 0};
//    vector<int> nums2 = {2, 5, 6};
//    Solution().merge(nums1, 3, nums2, 3);
//    for (int i = 0; i < nums1.size(); ++i) cout << nums1[i] << " ";

    vector<int> nums1 = {0};
    vector<int> nums2 = {1};
    Solution().merge(nums1, 0, nums2, 1);
    for (int i = 0; i < nums1.size(); ++i) cout << nums1[i] << " ";

    return 0;
}
