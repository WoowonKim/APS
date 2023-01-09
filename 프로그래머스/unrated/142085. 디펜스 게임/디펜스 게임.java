import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(;answer < enemy.length; answer++) {
            n -= enemy[answer];
            pq.add(enemy[answer]);
            if(n < 0) {
                if(k > 0 && !pq.isEmpty()){
                    n += pq.poll();
                    k--;
                } 
                else break;
            }
        }
        return answer;
    }
}