/**
* Given a matrix of m x n elements (m rows, n columns), 
* return all elements of the matrix in spiral order.
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix == null)
            return result;
        int rawTop = 0, rawBot = matrix.length - 1;
        int columnLeft = 0, columnRight = matrix[0].length - 1;
        while (rawTop <= rawBot && columnLeft <= columnRight) {
            for (int i = columnLeft; i <= columnRight; i++) {
                result.add(matrix[rawTop][i]);
            }
            rawTop++;
            for (int i = rawTop; i <= rawBot; i++) {
                result.add(matrix[i][columnRight]);
            }
            columnRight--;
            if (rawTop > rawBot || columnLeft > columnRight) break;
            for (int i = columnRight; i >= columnLeft; i--) {
                result.add(matrix[rawBot][i]);
            }
            rawBot--;
            for (int i = rawBot; i >= rawTop; i--) {
                result.add(matrix[i][columnLeft]);
            }
            columnLeft++;
        }
        return result;
    }
}
