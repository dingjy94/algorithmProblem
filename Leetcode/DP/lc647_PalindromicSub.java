/**
* Given a string, your task is to count how many palindromic substrings in this string.
* The substrings with different start indexes or end indexes are counted as 
* different substrings even they consist of same characters
*
* Key: center can be on char or between chars, thus loop's up range should be 2*String.length() - 1;
*/
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int size = s.length();
        for (int i = 0; i < 2 * size - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < size && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
            
        }
        return count;
        
    }
}
