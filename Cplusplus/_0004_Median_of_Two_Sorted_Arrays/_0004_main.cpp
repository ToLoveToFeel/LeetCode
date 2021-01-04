#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    // 在两个有序数组nums1和nums2中获取第k小(从1开始)的数据
    int getKthElement(vector<int>& nums1, vector<int>& nums2, int k) {

        int i = 0, j = 0;  // 当前考察的区间 nums1[i...], nums2[j...]
        while (true) {

            if (i == nums1.size()) return nums2[j + k - 1];
        }
    }


public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {


    }
};

int main() {


    return 0;
}
