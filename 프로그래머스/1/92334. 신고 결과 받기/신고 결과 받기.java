import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> ids = new ArrayList<>();
        for (String id : id_list) {
            ids.add(id);
        }
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : report) {
            String[] users = s.split(" ");
            map.computeIfAbsent(users[1], v -> new HashSet<>())
                .add(users[0]);
        }
        
        int[] answer = new int[id_list.length];
        
        for (String key : map.keySet()) {
            Set<String> users = map.get(key);
            if(users.size() < k) {
                continue;
            }
            
            for (String user : users) {
                answer[ids.indexOf(user)]++;
            }
        }
        
        return answer;
    }
}