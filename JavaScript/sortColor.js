// [2,0,2,1,1,0] => [0,0,1,1,2,2]
var sortColors = function(nums) {
    let start = 0, end = nums.length - 1;
    
    for (let i = 0; i <= end; i++) {
        if (nums[i] === 0 && i !== start) {
            [nums[i], nums[start]] = [nums[start], nums[i]];
            i--;
            start++;
        } else if (nums[i] === 2 && i !== end) {
            [nums[i], nums[end]] = [nums[end], nums[i]]; // swap
            end--;
            i--;
        }
    }
};
