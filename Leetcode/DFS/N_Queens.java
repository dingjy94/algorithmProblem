public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        
        dfs(result, n, new ArrayList<Integer>(), new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        
        return result;
    }
    
    private void dfs(List<List<String>> result,
                     int n,
                     List<Integer> curList,
                     boolean[] colVisited,
                     boolean[] leftRightVisited,
                     boolean[] rightLeftVisited) {
        if (curList.size() == n) {
            result.add(draw(curList));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            int row = curList.size();
            
            if (!isValid(i, row, n, colVisited, leftRightVisited, rightLeftVisited)) {
                continue;
            }
            
            curList.add(i);
            colVisited[i] = true;
            leftRightVisited[i + row] = true;
            rightLeftVisited[i - row + n] = true;
            dfs(result, n, curList, colVisited, leftRightVisited, rightLeftVisited);
            colVisited[i] = false;
            leftRightVisited[i + row] = false;
            rightLeftVisited[i - row + n] = false;
            curList.remove(curList.size() - 1);
        }
    }
    
    private boolean isValid(int col, 
                            int row, 
                            int n,
                            boolean[] colVisited, 
                            boolean[] leftRightVisited, 
                            boolean[] rightLeftVisited) {
        if (colVisited[col]) {
            return false;
        }
        if (leftRightVisited[col + row]) {
            return false;
        }
        if (rightLeftVisited[n + col - row]) {
            return false;
        }
        return true;
    }
    
    private List<String> draw(List<Integer> curList) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < curList.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < curList.size(); j++) {
                if (j == curList.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        
        return result;
    }
}
