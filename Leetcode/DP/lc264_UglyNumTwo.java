/**
* Write a program to find the n-th ugly number.
* Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
* For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
* Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
*/
class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) return 0;
        int[] result = new int[n];
        int twoList = 2;
        int threeList = 3;
        int fiveList = 5;
        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            
            int min = Math.min(twoList, Math.min(threeList, fiveList));
            result[i] = min;
            if (min == twoList)
                twoList = 2 * result[++twoIndex];
            if (min == threeList)
                threeList = 3 * result[++threeIndex];
            if (min == fiveList)
                fiveList = 5 * result[++fiveIndex];
        }
        return result[n - 1];
    }
}
