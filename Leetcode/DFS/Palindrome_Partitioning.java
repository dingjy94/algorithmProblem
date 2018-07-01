/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */
 
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        } else if (s.length() == 0) {
            result.add(new ArrayList<String>());
            return result;
        }
        
        dfs(s, 0, result, new ArrayList<String>());
        return result;
    }
    
    private void dfs(String s, int index, List<List<String>> result, List<String> curList) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curList));
            return;
        }
        
        int j = index;
        if (j + 1 > s.length()) {
            return;
        }
        
        while (j < s.length()) {
            String cur = s.substring(index, j + 1);
            if (isPartition(cur)) {
                curList.add(cur);
                dfs(s, j + 1, result, curList);
                curList.remove(curList.size() - 1);
            }
            j++;
        }
    }
    
    private boolean isPartition(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
