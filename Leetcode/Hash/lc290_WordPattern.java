/**
* Given a pattern and a string str, find if str follows the same pattern.
* Trick: HashMap.put() returns the previous value associated with key, or null if there was no mapping for key
*/
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i)
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            return false;
    return true;
}
