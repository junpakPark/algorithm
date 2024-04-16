import java.util.function.IntBinaryOperator;

class Solution {

    public static final Map<Character, IntBinaryOperator> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put('+', Integer::sum);
        OPERATORS.put('-', (a, b) -> a - b);
        OPERATORS.put('*', (a, b) -> a * b);
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (OPERATORS.containsKey(c)) {
                List<Integer> lefts = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rights = diffWaysToCompute(expression.substring(i + 1));

                for (int left : lefts) {
                    for (int right : rights) {
                        int result = OPERATORS.get(c).applyAsInt(left, right);
                        results.add(result);
                    }
                }
            }
        }

        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }
        return results;
    }
}
