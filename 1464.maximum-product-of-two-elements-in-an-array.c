/*
 * @lc app=leetcode id=1464 lang=c
 *
 * [1464] Maximum Product of Two Elements in an Array
 */

// @lc code=start
int maxProduct(int* nums, int numsSize) {
    int biggest = 0;
    int second_biggest = 0;

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] > biggest) {
            second_biggest = biggest;
            biggest = nums[i];
        } else if (nums[i] > second_biggest) {
            second_biggest = nums[i];
        }
    }

    return (biggest - 1) * (second_biggest - 1);
}
// @lc code=end

