import java.util.*;

class Solution {
    
    private int[] info;
    private int[] answer = new int[11];
    private int maxScore = 0;
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        dfs(0, new int[11], n);
        
        if (maxScore == 0) {
            return new int[] {-1};
        }
        return answer;
    }
    
    private void dfs (int index, int[] arr, int arrow) {
        if(index == arr.length) {
            arr[arr.length - 1] = arrow;
            int score = calculateScore(arr);
            if(score > maxScore) {
                maxScore = score;
                answer = Arrays.copyOf(arr, arr.length);
            }
            if(score == maxScore) {
                for (int i = 10; i >=0 ; i--) {
                    if(arr[i] == answer[i]) {
                        continue;
                    }
                    if(arr[i] > answer[i]) {
                        answer = Arrays.copyOf(arr, arr.length);
                    }
                    break;
                }
            }
            return;
        }
        
        if(info[index] < arrow) {
            arr[index] = info[index] + 1;
            dfs(index + 1, arr, arrow - arr[index]);
            arr[index] = 0;
        }
        dfs(index + 1, arr, arrow);
    }
    
    private int calculateScore(int[] arr) {
        int diff = 0;
        for (int i = 0; i < answer.length; i++) {
            if(arr[i] == 0 && info[i] == 0) {
                continue;
            }
            if (arr[i] > info[i]) {
                diff += (10 - i);
                continue;
            }
            diff -= (10 - i);
        }
        return diff;
    }
}