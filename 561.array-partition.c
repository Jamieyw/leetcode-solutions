/*
 * @lc app=leetcode id=561 lang=c
 *
 * [561] Array Partition
 */

// @lc code=start
int arrayPairSum(int* nums, int numsSize) {
    const int K = 10000;
    int *elementToCount = (int *)calloc(2 * K + 1, sizeof(int));

    for (int i = 0; i < numsSize; i++) {
        elementToCount[nums[i] + K]++;
    }

    int maxSum = 0;
    bool isOddIndex = true;
    for (int element = 0; element < 2 * K + 1; element++) {
        while (elementToCount[element] > 0) {
            if (isOddIndex) {
                maxSum += element - K;
            }
            isOddIndex = !isOddIndex;
            elementToCount[element]--;
        }
    }

    return maxSum;
}
// @lc code=end

