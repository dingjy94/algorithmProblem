/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * O(1) space
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColZero = false;
        int rowLen = matrix[0].length, colLen = matrix.length;
        
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRowZero = true;
                    }
                    if (j == 0) {
                        firstColZero = true;
                    }
                    
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i< colLen; i++) {
            for (int j = 1; j < rowLen; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstRowZero) {
            for (int i = 0; i < rowLen; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if (firstColZero) {
            for (int i = 0; i < colLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
