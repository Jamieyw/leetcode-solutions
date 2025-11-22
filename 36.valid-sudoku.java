/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int GRID_SIZE = 9;

        Map<Integer, Set<Character>> rowsMap = new HashMap<>(); // key = row number
        Map<Integer, Set<Character>> colsMap = new HashMap<>(); // key = col number
        // Java's HashMap requires a single object as the key. So, we can't use a pair of integers (r / 3, c / 3) as the key.
        Map<Integer, Set<Character>> squaresMap = new HashMap<>(); // key = (row / 3) * 3 + col / 3

        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
                char cell = board[r][c];

                if (cell == '.') {
                    continue;
                }

                // Initialize the sets if they do not exist
                rowsMap.putIfAbsent(r, new HashSet<>());
                colsMap.putIfAbsent(c, new HashSet<>());
                int squareIndex = (r / 3) * 3 + (c / 3);
                squaresMap.putIfAbsent(squareIndex, new HashSet<>());

                // check for duplicates
                if (rowsMap.get(r).contains(cell) || colsMap.get(c).contains(cell) || squaresMap.get(squareIndex).contains(cell)) {
                    return false;
                }

                // add the cell to the sets
                rowsMap.get(r).add(cell);
                colsMap.get(c).add(cell);
                squaresMap.get(squareIndex).add(cell);
            }
        }
        return true;
    }
}

// Different syntax
// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         Map<Integer, Set<Character>> cols = new HashMap<>();
//         Map<Integer, Set<Character>> rows = new HashMap<>();
//         Map<Integer, Set<Character>> squares = new HashMap<>();  // key = (r / 3) * 3 + c / 3

//         for (int r = 0; r < 9; r++) {
//             for (int c = 0; c < 9; c++) {
//                 char cell = board[r][c];
//                 if (cell == '.') {
//                     continue;
//                 }
//                 if (rows.getOrDefault(r, new HashSet<>()).contains(cell)
//                         || cols.getOrDefault(c, new HashSet<>()).contains(cell)
//                         || squares.getOrDefault((r / 3) * 3 + c / 3, new HashSet<>()).contains(cell)) {
//                     return false;
//                 }
//                 cols.computeIfAbsent(c, k -> new HashSet<>()).add(cell);
//                 rows.computeIfAbsent(r, k -> new HashSet<>()).add(cell);
//                 squares.computeIfAbsent((r / 3) * 3 + c / 3, k -> new HashSet<>()).add(cell);
//             }
//         }
//         return true;
//     }
// }
// @lc code=end

