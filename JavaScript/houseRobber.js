/**
 * @param {number[]} nums
 * @return {number}
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * (automatically contact the police if two adjacent houses were broken into on the same night.)
 */

var rob = function(nums) {
    let oddSum = evenSum = 0;
    
    for (let i = 0; i < nums.length; i++) {
        if (i % 2 === 0) {
            evenSum = Math.max(evenSum + nums[i], oddSum);
        } else {
            oddSum = Math.max(oddSum + nums[i], evenSum);
        }
    }
    
    return Math.max(evenSum, oddSum);
};
