/**
* Your are given an array of positive integers nums.
* Count and print the number of (contiguous) subarrays where the product of 
* all the elements in the subarray is less than k.
* 
* Idea: Slide window, if the product of the window is larger than k, drop the left most element.
*/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        long tmp = 1L;
        for (int low = 0, high = 0; high < nums.length; high++) {
             tmp *= nums[high];
            while (low <= high && tmp >= k) {
                tmp /= nums[low++];
            }   
            result += high - low + 1;               
        }
        return result;       
    }
}
