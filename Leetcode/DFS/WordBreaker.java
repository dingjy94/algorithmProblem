/*
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 */
public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        Map<String, List<String>> memo = new HashMap<>();
        return helper(s, wordDict, memo);
    }
    
    private List<String> helper(String s, Set<String> wordDict,  Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<>();
        
        if (s.length() == 0) {
            return result;
        }
        
        if (wordDict.contains(s)) {
            result.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String pre = s.substring(0, i);
            if (!wordDict.contains(pre)) {
                continue;
            }
            
            String tail = s.substring(i);
            List<String> combo = helper(tail, wordDict, memo);
            for (String tmp : combo) {
                result.add(pre + " " + tmp);
            }
        }
        
        memo.put(s, result);
        return result;
    }
}


