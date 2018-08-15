class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1,
            leftMax = 0, rightMax = 0, result = 0;
        
        while (left <= right) {
            if (height[left] > leftMax) {
                leftMax = height[left++];
                continue;
            }
            if (height[right] > rightMax) {
                rightMax = height[right--];
                continue;
            }
            
            if (leftMax <= rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        
        return result;
    }
}
