/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    // Approach 3: Binary Search (Optimal)
    // Time complexity: O(log(min(m,n)))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int half = (m + n) / 2;

        // Initialize pointers for binary search on nums1
        int left = 0;
        int right = m; // Using right = m (rather than m - 1) ensures that both of these edge partitions—no elements from A on the left and all elements from A on the left—are explored.

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = half - partitionA;

            int Aleft = (partitionA > 0) ? nums1[partitionA - 1] : Integer.MIN_VALUE;
            int Aright = (partitionA < m) ? nums1[partitionA] : Integer.MAX_VALUE;
            int Bleft = (partitionB > 0) ? nums2[partitionB - 1] : Integer.MIN_VALUE;
            int Bright = (partitionB < n) ? nums2[partitionB] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if ((m + n) % 2 == 0) { // even
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                } else { // odd
                    return Math.min(Aright, Bright);
                }
            }
            else if (Aleft > Bright) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }

        return 0.0;
    }


    // // Approach 1: Merge Sort (Time complexity: O(m+n))
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // int m = nums1.length;
        // int n = nums2.length;
        // int totalLength = m + n;

        // int i = 0;
        // int j = 0;
        // int newIndex = 0;
        // int currNum = 0;
        // int previousNum = 0;

        // while (newIndex <= totalLength / 2) {
        //     previousNum = currNum;
        //     if (i < m && (j >= n || nums1[i] < nums2[j])) {
        //         currNum = nums1[i++];
        //     } else {
        //         currNum = nums2[j++];
        //     }
        //     newIndex += 1;
        // }

        // if ((m + n) % 2 == 0) {
        //     // The median is the average of the two middle elements
        //     return (currNum + previousNum) / 2.0;
        // } else {
        //     // If the total length is odd, the median is the middle element
        //     return currNum;
        // }
    // }
}

// @lc code=end

