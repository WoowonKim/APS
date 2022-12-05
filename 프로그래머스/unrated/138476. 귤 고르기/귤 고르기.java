import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] counter = new int[10000001];
        for(int i = 0; i < tangerine.length; i++) {
            counter[tangerine[i]]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < 10000001; i++) {
            if(counter[i]>0) {
                pq.add(counter[i]);
            }
        }
        while(k > 0) {
            answer++;
            k -= pq.poll();
        }
        return answer;
    }
}