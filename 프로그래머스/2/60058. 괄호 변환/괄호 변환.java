import java.util.*;

class Solution {
    
    private static final char OPEN = '(';
    private static final char CLOSE = ')';
    
    public String solution(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
        if (p == null || p.isEmpty()) {
            return "";
        }
        
        // p가 이미 "올바른 괄호 문자열"이라면 그대로 return 하면 됩니다.
        if (isRight(p)) {
            return p;
        }
        
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        String u = "";
        String v = "";
        for (int i = 2; i <= p.length(); i+=2) {
            final String substring = p.substring(0, i);
            
            // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며
            if (isBalanced(substring)) {
                u = substring;
                v = p.substring(i);
                break;
            }
        }
        
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
        if (isRight(u)) {
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u + solution(v);
        }
        
        final StringBuilder sb = new StringBuilder();
        // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
        sb.append(OPEN);
        //  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
        sb.append(solution(v));
        // 4-3. ')'를 다시 붙입니다. 
        sb.append(CLOSE);
        
        for (char c : u.substring(1, u.length() -1).toCharArray()) {
            if (c == OPEN) {
                sb.append(CLOSE);
            } else {
                sb.append(OPEN);
            }
        }
        
        return sb.toString();
    }
    
    private boolean isRight(String w) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (char c : w.toCharArray()) {
            if(c == OPEN) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || stack.peek() != OPEN) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
    
    private boolean isBalanced(String w) {
        int open = 0;
        int close = 0;
        for (char c : w.toCharArray()) {
            if (c == OPEN) {
                open++;
            } else {
                close++;
            }
        }
        return open == close;
    }
    
}