class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Signs are only valid at the very beginning or immediately after an exponent ('e' or 'E')
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // A dot is invalid if we have already seen a dot or an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // An exponent is valid only if we haven't seen one yet and we have already seen a digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                // Reset seenDigit so that digits are required *after* the exponent (e.g., "1e" is invalid)
                seenDigit = false;
            } else {
                // Any other character is invalid
                return false;
            }
        }
        
        // A valid number must have at least one digit
        return seenDigit;
    }
}