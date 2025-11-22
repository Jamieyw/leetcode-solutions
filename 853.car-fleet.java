/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start

import java.util.Arrays;
import java.util.Stack;

// // Solution 1: Stack-based
// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n = position.length;
//         int[][] pair = new int[n][2];
//         for (int i = 0; i < n; i++) {
//             pair[i][0] = position[i];
//             pair[i][1] = speed[i];
//         }

//         // Sorts 2D array pair in descending order based on position
//         // The car at the front will be the first element in the array.
//         Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

//         // Stack operations
//         Stack<Double> stack = new Stack<>();
//         for (int[] p : pair) {
//             double time = (double) (target - p[0]) / p[1];
//             stack.push(time);
//             // Check for fleet collision

//             // If the current car will collide with the previous car in the stack,
//             // pop the current car from the stack as they will form a fleet.

//             // Use an if statement instead of a while loop because once the current car
//             // catches up with the previous car, they will travel together at the same speed.
//             // Since the previous car didn't form a fleet with the car in front of it,
//             // the current car will never catch up with the car in front of the previous car.
//             if (stack.size() >= 2 && 
//                 stack.peek() <= stack.get(stack.size() - 2)) 
//                 {
//                     stack.pop();
//                 }
//         }

//         return stack.size();
//     }
// }


// Solution 2: Car class-based
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        // Sort cars by position (ascending)
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        // Fleet Counting Algorithm
        int ans = 0;
        int currCarNum = n;
        while (--currCarNum > 0) { // Pre-decrement currCarNum before comparison
            if (cars[currCarNum].time < cars[currCarNum - 1].time) { // If the first car arrives sooner, it can't be caught
                ans++;  // New fleet forms
            } else { // Merge cars into fleet: second (faster) car merges into first (slower) car
                cars[currCarNum - 1] = cars[currCarNum];
            }
        }
        return ans + (currCarNum == 0 ? 1 : 0); // Lone car is a fleet (if it exists)
    }
}

class Car {
    int position;   // Starting position
    double time;    // Time to reach target
    Car(int p, double t) {
        position = p;
        time = t;
    }
}
// @lc code=end

