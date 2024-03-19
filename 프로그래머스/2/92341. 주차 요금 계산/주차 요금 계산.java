import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Queue<Integer>> in = new HashMap<>();
        Map<Integer, Queue<Integer>> out = new HashMap<>();

        for (String s : records) {
            String[] record = s.split(" ");

            int time = convertTime(record[0]);
            int carNumber = Integer.parseInt(record[1]);

            if ("IN".equals(record[2])) {
                in.computeIfAbsent(carNumber, k -> new PriorityQueue<>())
                        .offer(time);
            }
            if ("OUT".equals(record[2])) {
                out.computeIfAbsent(carNumber, k -> new PriorityQueue<>())
                        .offer(time);
            }
        }

        List<Integer> carNumbers = new ArrayList<>(in.keySet());
        carNumbers.sort(Comparator.naturalOrder());

        int[] answer = new int[carNumbers.size()];

        for (int i = 0; i < carNumbers.size(); i++) {
            int carNumber = carNumbers.get(i);

            Queue<Integer> ins = in.get(carNumber);
            Queue<Integer> outs = out.getOrDefault(carNumber, new LinkedList<>());

            int totalTime = -fees[0];

            while (!ins.isEmpty()) {

                Integer outTime = outs.poll();
                Integer inTime = ins.poll();

                if (outTime == null) {
                    outTime = convertTime("23:59");
                }
                if (inTime == null) {
                    break;
                }

                totalTime += (outTime - inTime);
            }

            int targetTime = Math.max(0, totalTime);
            int extraFee = (int) Math.ceil((float) targetTime / fees[2]) * fees[3];
            
            answer[i] = fees[1] + extraFee;
        }

        return answer;
    }

    private int convertTime(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]) * 60;
        int minute = Integer.parseInt(times[1]);

        return hour + minute;
    }
}
