class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        char[] chars = s.toCharArray();
        
        for (int i = chars.length - 1; i > 0; i--) {
            int bit = chars[i] - '0' + carry;

            if (bit == 1) {
                carry = 1;
                steps += 2;
                continue;
            } 
            steps += 1; 
        }
        
        return steps + carry;
    }
}