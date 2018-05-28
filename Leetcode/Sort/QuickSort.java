public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[]A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = A[(left + right) / 2];
        while (left < right) {
            // if same number exists, puts == in one condition(<= or >=);
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            // (left <= right)
            if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }
        //After while loop, left >= right
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
