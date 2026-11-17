class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the least significant digit to the most significant
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, simply increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Otherwise, set current digit to 0 and continue carry to the left
            digits[i] = 0;
        }

        // If all digits were 9 (e.g., [9, 9]), we need an extra digit at the front
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}