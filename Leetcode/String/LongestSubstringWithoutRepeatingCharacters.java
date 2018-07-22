/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int right = 0, max = 0, left = 0;
        
            while (right < s.length()) {
                char cur = s.charAt(right);
                if (hash.containsKey(cur)) {
                    left = Math.max(left, hash.get(cur) + 1);
                }
                
                hash.put(cur, right);
                right++;
                
                if (right - left > max) {
                  max = right - left;            
                }
            }


        
        return max;
    }
}
