/**
* Given a list of words and two words word1 and word2, 
* return the shortest distance between these two words in the list.
* word1 and word2 may be the same and they represent two individual words in the list.
*/

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int first = -1, second = -1, result = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2)) {
                if (words[i].equals(word1)) {
                    if (first == -1) first = i;
                    else if (second == -1) second = i;
                    else {
                        first = second;
                        second = i;
                    }
                }
            } else if(words[i].equals(word1)) {
                first = i;
            } else if (words[i].equals(word2)) {
                second = i;
            }
            if (first != -1 && second != -1)
                result = Math.min(result, Math.abs(first - second));
        }
        
        return result;
    }
}
