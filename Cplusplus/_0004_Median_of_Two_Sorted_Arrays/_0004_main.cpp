#include <iostream>
#include <vector>

using namespace std;

/**
 * 执行用时：60 ms, 在所有 C++ 提交中击败了61.35%的用户
 * 内存消耗：87.3 MB, 在所有 C++ 提交中击败了67.66%的用户
 */
class Solution {

private:
    // 在两个有序数组nums1和nums2中获取第k小(从1开始)的数据
    int getKthElement(vector<int> &nums1, vector<int> &nums2, int k) {

        int i = 0, j = 0;  // 当前考察的区间 nums1[i...], nums2[j...]
        while (true) {

            if (i == nums1.size()) return nums2[j + k - 1];
            if (j == nums2.size()) return nums1[i + k - 1];
            if (k == 1) return min(nums1[i], nums2[j]);

            int newI = min(i + k / 2, (int) nums1.size()) - 1;
            int newJ = min(j + k / 2, (int) nums2.size()) - 1;
            if (nums1[newI] <= nums2[newJ]) {
                k -= (newI - i + 1);
                i = newI + 1;
            } else {
                k -= (newJ - j + 1);
                j = newJ + 1;
            }
        }
    }

public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {

        int n = nums1.size() + nums2.size();

        if ((n & 1) == 1)
            return getKthElement(nums1, nums2, n / 2 + 1);  // 获取第 n / 2 + 1 小的数据
        else
            return (getKthElement(nums1, nums2, n / 2) + getKthElement(nums1, nums2, n / 2 + 1)) / 2.0;
    }
};

int main() {

    vector<int> nums1 = {1, 2};
    vector<int> nums2 = {3, 4};
    cout << Solution().findMedianSortedArrays(nums1, nums2) << endl;

    return 0;
}
/*
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
 * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
 * 这里的 "/" 表示整除
 * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
 * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
 * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
 * 这样 pivot 本身最大也只能是第 k-1 小的元素
 * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
 * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
 * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
 */
