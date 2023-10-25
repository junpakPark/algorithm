import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> playerMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for (String calling : callings) {
            int nowRank = playerMap.get(calling);
            String playerInFront = players[nowRank - 1];
            
            playerMap.put(calling, nowRank - 1);
            playerMap.put(playerInFront, nowRank);
                    
            players[nowRank] = playerInFront;
            players[nowRank - 1] = calling;
        }
        
        return players;
    }
}