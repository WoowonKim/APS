import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long total1 = 0;
        long total2 = 0;
        for(int i = 0; i < queue1.length; i++){
            total1 += queue1[i];
            q1.add(queue1[i]);
            total2 += queue2[i];
            q2.add(queue2[i]);
        }
        long total = total1 + total2;
        if(total % 2 == 1) return -1; 
        int cnt = 0;
        while(true){
             cnt++;
            if(q1.isEmpty() || q2.isEmpty() || cnt > 1200000){
                answer = -1;
                break;
            }
            if(total1 > total2){
                int num1 = q1.poll();
                if(num1 > total/2){
                    answer = -1;
                    break;
                }
                total1 -= num1;
                total2 += num1;
                q2.add(num1);
            } else if(total2 > total1) {
                int num2= q2.poll();
                if(num2 > total/2){
                    answer = -1;
                    break;
                }
                total1 += num2;
                total2 -= num2;
                q1.add(num2);
            } else {
                answer = cnt-1;
                break;
            }
           
        }
        return answer;
    }
}