/**
* Find the contiguous subarray within an array (containing at least one number) 
* which has the largest product.
* Dynamic programmming? store max and min value;
* Proudcut question should always store min and max because negative integer;
* 
*/
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length <= 0 || nums == null)
            return 0;
        int result = nums[0];
        int max = nums[0], min = nums[0]; // initialize with n[0], since Integer.MIN_VALUE's product cause some trouble
        
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(nums[i], max * nums[i]), min * nums[i]);
            min = Math.min(Math.min(nums[i], min * nums[i]), tmp * nums[i]);
            if (max > result) result = max;
        }
        return result;
    }
}
