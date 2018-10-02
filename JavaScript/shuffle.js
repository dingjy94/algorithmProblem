/**
 * @param {number[]} nums
 */
var Solution = function(nums) {
    this.nums = nums;
    this.original = nums.slice(0);
};

/**
 * Resets the array to its original configuration and return it.
 * @return {number[]}
 */
Solution.prototype.reset = function() {
    this.nums = this.original.slice(0);
    return this.nums;
};

/**
 * Returns a random shuffling of the array.
 * @return {number[]}
 */
 
/** 
 * the modern version of the Fisher–Yates shuffle algorithm
 * equivalent version: for i from 0 to n−2 do
 *    j ← random integer such that i ≤ j < n   
 */
Solution.prototype.shuffle = function() {
    for (let i = this.nums.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [this.nums[i], this.nums[j]] = [this.nums[j], this.nums[i]];
    }
    
    return this.nums;
};
