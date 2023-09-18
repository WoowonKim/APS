import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList();
		Queue<Integer> queue = new LinkedList<>();
        for(int i : arr) queue.add(i);
        list.add(queue.poll());
        int last = list.get(0);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == last) continue;
            last = curr;
            list.add(curr);
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}