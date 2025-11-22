/*
 * @lc app=leetcode id=1365 lang=c
 *
 * [1365] How Many Numbers Are Smaller Than the Current Number
 */

// @lc code=start
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* smallerNumbersThanCurrent(int* nums, int numsSize, int* returnSize) {
    int min = nums[0], max = nums[0];
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] < min) min = nums[i];
        if (nums[i] > max) max = nums[i];
    }

    int range = max - min + 1;
    int *count = calloc(range, sizeof(int));
    int *result = malloc(sizeof(int) * numsSize);
    *returnSize = numsSize;

    for (int i = 0; i < numsSize; i++) {
        count[nums[i] - min]++;
    }
    for (int i = 1; i < range; i++) {
        count[i] += count[i - 1];
    }

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != min) {
            result[i] = count[nums[i] - min - 1];
        } else {
            result[i] = 0;
        }
    }

    return result;

    // // Brute force
    // int *result = (int *) malloc(sizeof(int) * numsSize);
    // *returnSize = numsSize;

    // for (int i = 0; i < numsSize; i++) {
    //     int cnt = 0;
    //     for (int j = 0; j < numsSize; j++) {
    //         if (nums[j] < nums[i]) {
    //             cnt++;
    //         }
    //     }
    //     result[i] = cnt;
    // }

    // return result;
}
// @lc code=end

