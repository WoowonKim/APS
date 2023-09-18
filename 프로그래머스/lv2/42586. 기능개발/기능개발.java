import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> temp = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < progresses.length; i++) {
            int left = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
            queue.add(left);
        }
        while(!queue.isEmpty()) {
            int cnt = 1;
            int curr = queue.poll();
            while(!queue.isEmpty() && queue.peek() <= curr) {
                queue.poll();
                cnt++;
            }
            temp.add(cnt);
        }
        
        answer = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}