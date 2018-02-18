/**
* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
*/

class NumArray {

    private int[] array;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            array = new int[nums.length];
            array[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                array[i] = nums[i] + array[i - 1];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? array[j] : (array[j] - array[i - 1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
