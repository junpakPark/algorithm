import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        final List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        
        for (int i = 1; i <= 8; i++) {
            final Set<Integer> set = new HashSet<>();
            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int op1 : dp.get(j)) {
                    for (int op2 : dp.get(k)) {
                        set.add(op1 + op2);
                        set.add(op1 - op2);
                        set.add(op1 * op2);
                        if (op2 != 0) {
                            set.add(op1 / op2);
                        }
                    }
                }
            }
            dp.add(set);
            
            if (set.contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}