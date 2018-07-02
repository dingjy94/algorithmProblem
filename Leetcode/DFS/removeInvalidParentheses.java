  /**
   * Remove the minimum number of invalid parentheses in order to make the input string valid. 
   * Return all possible results.
   */
  public class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> result = new ArrayList<>();
        
        int[] count = getLeftRightCount(s);
        dfs(s, count[0], count[1], 0, result);
        
        return result;
    }
    
    private void dfs(String s, int left, int right, int index, List<String> result) {
        if (left == 0 && right == 0 && isValid(s)) {
            result.add(s);
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (i > index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            if (s.charAt(i) == '(' && left > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), left - 1, right, i, result);
            }
            
            if (s.charAt(i) == ')' && right > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), left, right - 1, i, result);
            }
        }
    }
        
        
    private boolean isValid(String s) {
        int[] count = getLeftRightCount(s);
        return count[0] == 0 && count[1] == 0;
    }
        
    private int[] getLeftRightCount(String s) {
        int[] result = new int[2];
        for(char c : s.toCharArray()) {
            if (c == '(') {
                result[0]++;
            } else if (c == ')') {
                if (result[0] > 0) {
                    result[0]--;
                } else {
                    result[1]++;
                }
            }
        }
        return result;
    }
   
}
