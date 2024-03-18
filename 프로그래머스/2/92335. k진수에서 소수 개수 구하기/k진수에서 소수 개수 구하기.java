class Solution {
    public int solution(int n, int k) {
        String kNum = Integer.toString(n, k);
        String[] numbers = kNum.split("0");

        int answer = 0;
        for (String num : numbers) {
            if (num.isEmpty()) {
                continue;
            }

            long number = Long.parseLong(num);
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long number) {
        if (number == 1 || (number > 2 && number % 2 == 0)) {
            return false;
        }
        for (int i = 3; i <= (int) Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
