class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (n < m) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmp2 = m;
            m = n;
            n = tmp2;
        }
        
        int min = 0, max = m, half = (m + n + 1) / 2;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = half - i;
            
            if (i < max && nums1[i] < nums2[j - 1]) {
                min++;
            } else if (i > min && nums1[i - 1] > nums2[j]) {
                max--;
            } else {
                int maxleft, minright = 0;
                
                if (i == 0) {
                    maxleft = nums2[j - 1];
                } else if (j == 0) {
                    maxleft = nums1[i - 1];
                } else {
                    maxleft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxleft; 
                }
                
                if (i == m) {
                    minright = nums2[j];
                } else if (j == n) {
                    minright = nums1[i];
                } else {
                    minright = Math.min(nums1[i], nums2[j]);
                }
                return (minright + maxleft) / 2.0;                
                
            }
        }
        
        return 0.0;
    }
}
