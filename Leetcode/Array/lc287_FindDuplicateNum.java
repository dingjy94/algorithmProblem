/**
* Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
* prove that at least one duplicate number must exist. 
* Assume that there is only one duplicate number, find the duplicate one.
* Note:
* You must not modify the array (assume the array is read only).
* You must use only constant, O(1) extra space.
* Your runtime complexity should be less than O(n2).
* There is only one duplicate number in the array, but it could be repeated more than once.
*
* Idea: Floyd's Tortoise and Hare (Cycle detection)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = 0;
        int fast = nums[0], slow = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (slow != fast);
        
        int pre1 = nums[0], pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
