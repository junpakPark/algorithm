import java.util.*;

class Solution {
    public long solution(String expression) {
        final List<String> tokens = new ArrayList<>();
        final Set<String> ops = new HashSet<>();
        final StringBuilder sb = new StringBuilder();
        for (var c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }
            tokens.add(sb.toString());
            sb.setLength(0);
            final String op = String.valueOf(c);
            tokens.add(op);
            ops.add(op);
        }
        tokens.add(sb.toString());

        final List<List<String>> permutations = new ArrayList<>();
        permute(new ArrayList<>(ops), 0, permutations);

        long answer = 0;
        for (List<String> precedence : permutations) {
            long result = evaluate(new ArrayList<>(tokens), precedence);
            answer = Math.max(answer, Math.abs(result));
        }
        return answer;
    }

    private void permute(List<String> ops, int start, List<List<String>> result) {
        if (start == ops.size()) {
            result.add(new ArrayList<>(ops));
            return;
        }
        for (int i = start; i < ops.size(); i++) {
            Collections.swap(ops, i, start);
            permute(ops, start + 1, result);
            Collections.swap(ops, i, start);
        }
    }

    private long evaluate(List<String> tokens, List<String> precedence) {
        for (String op : precedence) {
            List<String> temp = new LinkedList<>();
            Iterator<String> it = tokens.iterator();
            String prev = it.next();
            while (it.hasNext()) {
                String curr = it.next();
                if (curr.equals(op)) {
                    String next = it.next();
                    prev = String.valueOf(calc(Long.parseLong(prev), Long.parseLong(next), op));
                    continue;
                }
                temp.add(prev);
                prev = curr;
            }
            temp.add(prev);
            tokens = temp;
        }
        return Long.parseLong(tokens.get(0));
    }

    private long calc(long a, long b, String op) {
        if ("+".equals(op)) {
            return a + b;
        }
        if ("-".equals(op)) {
            return a - b;
        }
        return a * b;
    }
}
