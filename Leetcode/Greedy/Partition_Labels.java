/**
 * A string S of lowercase letters is given. 
 * We want to partition this string into as many parts as possible so that each letter 
 * appears in at most one part, and return a list of integers representing the size of these parts.
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        
        int curEnd = 0;
        int curStart = 0;
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < S.length(); i++) {
            curEnd = Math.max(curEnd, last[S.charAt(i) - 'a']);
            
            if (curEnd == i) {
                result.add(i - curStart + 1);
                curStart = i + 1;
            }
        }
        
        return result;
    }
}
