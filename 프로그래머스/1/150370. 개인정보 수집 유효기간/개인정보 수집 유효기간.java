import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] splits = term.split(" ");
            termsMap.put(splits[0], Integer.parseInt(splits[1]));
        }
        
        int todayDate = convertDate(today);
        
        List<Integer> expiredDate = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] splits = privacies[i].split(" ");
            int endDate = convertDate(splits[0]) + termsMap.get(splits[1]) * 28;
            
            if(todayDate >= endDate) {
                expiredDate.add(i);
            }
        }
        
        int[] answer = new int[expiredDate.size()];
        for (int i = 0; i < expiredDate.size(); i++) {
            answer[i] = expiredDate.get(i) + 1;
        }
        return answer;
    }
    
    private int convertDate(String date) {
        String[] dates = date.split("\\.");
        
        int year = (Integer.parseInt(dates[0]) - 2000) * 12 * 28;
        int month = (Integer.parseInt(dates[1]) - 1) * 28;
        int day = Integer.parseInt(dates[2]);
        
        return year + month + day;
    }
}