import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> logs = new HashMap<>();
        Map<Integer, Integer> parkedTime = new HashMap<>();

        for (String record : records) {
            String[] log = record.split(" ");

            int time = convertTime(log[0]);
            int carNumber = Integer.parseInt(log[1]);

            if (log[2].equals("IN")) {
                logs.put(carNumber, time);
                continue;
            }
            int parkedDuration = time - logs.remove(carNumber);
            parkedTime.put(carNumber, parkedTime.getOrDefault(carNumber, 0) + parkedDuration);
        }

        for (Map.Entry<Integer, Integer> log : logs.entrySet()) {
            int lastTime = convertTime("23:59") - log.getValue();

            parkedTime.put(log.getKey(), parkedTime.getOrDefault(log.getKey(), 0) + lastTime);
        }

        List<Integer> carNumbers = new ArrayList<>(parkedTime.keySet());
        carNumbers.sort(Integer::compare);

        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            int totalTime = parkedTime.get(carNumbers.get(i));
            answer[i] = calculateFee(fees, totalTime);
        }

        return answer;
    }

    private int convertTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private int calculateFee(int[] fees, int totalTime) {
        if (totalTime <= fees[0]) {
            return fees[1];
        }

        return fees[1] + (int) Math.ceil((float) (totalTime - fees[0]) / fees[2]) * fees[3];
    }
}
