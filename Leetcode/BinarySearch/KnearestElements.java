/**
* Given a target number, a non-negative integer target and an 
* integer array A sorted in ascending order, find the k closest numbers to target in A, 
* sorted in ascending order by the difference between the number and target. 
* Otherwise, sorted in ascending order by number if the difference is same.
*/

public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    int start = 0, end = 0;
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        if (A == null || A.length == 0) {
            return A;
        }
        end = A.length - 1;
        searchPosition(A, target);
        return getKClosest(A, target, k);
    }
    
    private void searchPosition(int[] A, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
    }
    private int[] getKClosest(int[] A, int target, int k) {
        if (k > A.length) {
            k = A.length;
        }
        int[] result = new int[k];
        int count = 0;
        while (count < k && start >= 0 && end < A.length) {
            if (target - A[start] <= A[end] - target) {
                result[count] = A[start];
                start--;
                count++;
            } else if (target - A[start] > A[end] - target) {
                result[count] = A[end];
                end++;
                count++;
            }
        }
        if (count < k && start < 0) {
            while (count < k) {
                result[count] = A[end];
                count++;
                end++;
            }
        } else if (count < k && start >= 0) {
            while (count < k) {
                result[count] = A[start];
                count++;
                start--;
            }
        }
        return result;
    }
}
