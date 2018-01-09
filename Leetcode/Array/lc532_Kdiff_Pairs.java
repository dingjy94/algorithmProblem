// Given an array of integers and an integer k, you need to find the number of 
//unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), 
//where i and j are both numbers in the array and their absolute difference is k.

class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) result++;
            } else {
                if (map.containsKey(entry.getKey() + k)) result++;
            }
        }
        
        return result;
        
    }
}
