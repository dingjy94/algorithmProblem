/**
* Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
* some elements appear twice and others appear once.
* Find all the elements that appear twice in this array.
* do it without extra space and in O(n) runtime.
* Idea: if a[i] == n, turn a[n - 1] to negative; then, if a[i] is negative, a[i] is duplicate.
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0)
                result.add(Math.abs(nums[i]));
            else 
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }
        
        return result;
    }
}
