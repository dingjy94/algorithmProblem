public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
       
        boolean isNegative = false;
        if (n < 0) {
            x = 1 / x;
            isNegative = true;
            n = -(n + 1);
        }
        double result = 1, tmp = x;
        while (n != 0) {
            if (n % 2 == 1) {
                result *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }
        if (isNegative) {
            result *= x;
        }
        return result;
    }
}
