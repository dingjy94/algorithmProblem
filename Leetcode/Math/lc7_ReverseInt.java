/**
* Given a 32-bit signed integer, reverse digits of an integer.
* Easy question, but some trick to '32-bit'
*/
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int tmp = tail + result * 10;
            if ((tmp - tail) / 10 != result) // if overflow
            { return 0;}
            result = tmp;
            x = x / 10;
        }
        return result;
    }
}
