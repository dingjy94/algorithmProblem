class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
       
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] nums, int target, List<List<Integer>> result, List<Integer> temp, int start) {
            if (target < 0) return;
        
            else if (target == 0) {
                result.add(new ArrayList<>(temp));
            }
            else {
               for (int i = start; i < nums.length; i++) {
                   temp.add(nums[i]);
                   backtrack(nums, target - nums[i], result, temp, i);
                   temp.remove(temp.size() - 1);
               } 
            }
    }
    
}
