class Solution {
      public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[0]));

        PriorityQueue<long[]> heap = new PriorityQueue<>(n, (r1, r2) -> {
            if (r1[1] == r2[1]) {
                return Long.compare(r1[0], r2[0]);
            }
            return Long.compare(r1[1], r2[1]);
        });
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        int[] roomToMeetingCount = new int[n];
        int result = n;
        int maxMeetingCount = 0;

        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }

        for (int[] meeting : meetings) {
            while (!heap.isEmpty() && heap.peek()[1] <= (long) meeting[0]) {
                long[] next = heap.poll();
                freeRooms.add((int) next[0]);
            }

            if (!freeRooms.isEmpty()) {
                int earliestRoom = freeRooms.poll();
                heap.add(new long[]{(long) earliestRoom, (long) meeting[1]});
                roomToMeetingCount[earliestRoom]++;
                if (maxMeetingCount < roomToMeetingCount[earliestRoom] || (
                        maxMeetingCount == roomToMeetingCount[earliestRoom] && result > earliestRoom)) {
                    result = earliestRoom;
                    maxMeetingCount = roomToMeetingCount[earliestRoom];
                }
                continue;
            }
            long[] next = heap.poll();
            int earliestRoom = (int) next[0];
            long freeTime = next[1];
            heap.add(new long[]{next[0], freeTime + (long) (meeting[1] - meeting[0])});
            roomToMeetingCount[earliestRoom]++;
            if (maxMeetingCount < roomToMeetingCount[earliestRoom] || (
                    maxMeetingCount == roomToMeetingCount[earliestRoom] && result > earliestRoom)) {
                result = earliestRoom;
                maxMeetingCount = roomToMeetingCount[earliestRoom];
            }
        }
        return result;
    }
}