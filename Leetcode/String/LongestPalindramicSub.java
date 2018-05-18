public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int curLen = 0;
        String result = "";
        for (int i = 0; i < len; i++) {
            if (isValid(s, i - curLen, i)) {
                result = s.substring(i - curLen, i + 1);
                curLen++;
                
            } 
            if (isValid(s, i - curLen - 1, i)) {
                result = s.substring(i - curLen - 1, i + 1);
                curLen += 2;
                
            }
            
        }
        return result;
    }
    
    private boolean isValid(String s, int start, int end) {
        if (start < 0) return false;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
