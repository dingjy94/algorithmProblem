/**
* Given a 2D board and a word, find if the word exists in the grid.
* The word can be constructed from letters of sequentially adjacent cell, 
* where "adjacent" cells are those horizontally or vertically neighboring. 
* The same letter cell may not be used more than once.
*/
class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == w[0] && search(0, w, board, i, j))
                    return true;
        }
        return false;
    }
    
    private boolean search(int start, char[] w, char[][] board, int i, int j) {
        if (start >= w.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || w[start] != board[i][j] || visited[i][j]) return false;
        visited[i][j] = true;
        if (search(start + 1, w, board, i + 1, j) || search(start + 1, w, board, i - 1, j) || search(start + 1, w, board, i, j + 1) || search(start + 1, w, board, i, j - 1)) return true;
        visited[i][j] = false;
        return false;
        
    }
}
