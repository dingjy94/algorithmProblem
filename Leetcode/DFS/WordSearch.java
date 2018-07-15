/**
 * Given a matrix of lower alphabets and a dictionary. 
 * Find all words in the dictionary that can be found in the matrix. 
 * A word can start from any position in the matrix and go left/right/up/down 
 * to the adjacent position. One character only be used once in one word.
 */

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    private Map<String, Boolean> preMap = new HashMap<>(); 
    private static int[] dx = {0, 1, -1, 0};
    private static int[] dy = {1, 0, 0, -1};
    
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        Set<String> result = new HashSet<>();
        
        if (board == null || board.length == 0) {
            return new ArrayList<String>();
        }
        constructPre(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, new StringBuilder(), result, new boolean[board.length][board[0].length]);
            }
        }
        
        
        return new ArrayList<String>(result);
    }
    
    private void constructPre(List<String> words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String cur = word.substring(0, i + 1);
                if(!preMap.containsKey(cur)) {
                    preMap.put(cur, false);
                }
            }
            preMap.put(word, true);
        }
    }
    
    private void dfs(char[][] board,
                     int row,
                     int col,
                     StringBuilder sb,
                     Set<String> result,
                     boolean[][] visited) {
        sb.append(board[row][col]);
     //   System.out.println(sb.toString());
        if (preMap.containsKey(sb.toString())) {
            // System.out.println(sb.toString());
            if (preMap.get(sb.toString())) {
                result.add(sb.toString());
            }
        } else {
            // System.out.println(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        
        visited[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && !visited[nextRow][nextCol]) {
                dfs(board, nextRow, nextCol, sb, result, visited);
            }
        }
        
        visited[row][col] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
