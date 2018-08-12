class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int sum = a * b + res[i + j + 1];
                
                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            if (sb.length() == 0 && i == 0) {
                continue;
            }
            sb.append(i);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
