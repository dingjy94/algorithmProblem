/**
* A message containing letters from A-Z is being encoded to numbers using the following mapping:
* 'A' -> 1 ... 'Z' -> 26
* Given an encoded message containing digits, determine the total number of ways to decode it.
* For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
* The number of ways decoding "12" is 2.
*/

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s == null) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            if (Integer.valueOf(s.substring(i - 1, i)) != 0) {
                dp[i] += dp[i - 1];
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
