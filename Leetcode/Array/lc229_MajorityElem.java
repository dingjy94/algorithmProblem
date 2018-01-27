/**
* Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
* The algorithm should run in linear time and in O(1) space.
* 
* Idea: Boyer-Moore Algorithm
* In the first pass, we need 2 values: 1. A candidate value, initially set to any value.
* 2. A count, initially set to 0. For each element in our input list, we first examine the count value. 
* If the count is equal to 0, we set the candidate to the value at the current element. 
* Next, first compare the element's value to the current candidate value. 
* If they are the same, we increment count by 1. 
* If they are different, we decrement count by 1.
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int a1 = 0, b1 = 1, a = 0, b = 0;
        for (int i : nums) {
            if (i == a1)
                a++;
            else if (i == b1)
                b++;
            else if (a == 0) {
                a1 = i;
                a++;
            }
            else if (b == 0) {
                b1 = i;
                b++;
            }
            else {
                a--;
                b--;
            }
        }
        int counta = 0, countb = 0;
        for (int i : nums) {
            if (i == a1)
                counta++;
            else if (i == b1)
                countb++;
        }
        if (counta > nums.length/3) result.add(a1);
        if (countb > nums.length/3) result.add(b1);
        return result;
    }
}
