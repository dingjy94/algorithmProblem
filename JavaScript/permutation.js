/**
 * Given a collection of distinct integers, return all possible permutations.
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    const result = [];
    backtrack([], result, nums);
    return result;
};

function backtrack(curList, result, nums) {
    if (curList.length === nums.length) {
    // copy the array
        result.push(curList.slice());      
        return;
    }
    
    for (let i of nums) {
        if (curList.includes(i)) {
            continue;
        }
      
        curList.push(i)
        backtrack(curList, result, nums);
        curList.pop();
    }
}
