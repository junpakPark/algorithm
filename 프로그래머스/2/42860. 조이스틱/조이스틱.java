class Solution {
    public int solution(String name) {
        int lr = 0;
        int ud = name.length()- 1;
        
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            lr += Math.min(c - 'A', 'Z' - c + 1);
            
            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            ud = Math.min(ud, Math.min(2 * i + (name.length() - next), 2 *(name.length() - next) + i));
        }
        
        return lr + ud;
    }
}