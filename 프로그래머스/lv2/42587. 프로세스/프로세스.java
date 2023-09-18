import java.util.*;

class Solution {
    static class Process implements Comparable<Process> {
        int num, priority;
        public Process(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
        public int compareTo(Process o) {
            return this.priority - o.priority; 
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Process> pq = new PriorityQueue<Process>(Comparator.reverseOrder());
        Queue<Process> queue = new LinkedList<Process>();
        for(int i = 0; i < priorities.length; i++) {
            Process p = new Process(i, priorities[i]);
            pq.add(p);
            queue.add(p);
        }
        while(!pq.isEmpty()) {
            Process curr = pq.poll();
            int max = curr.priority;
            Process poll = null;
            while(true) {
                if(queue.peek().priority == max) {
                    answer++;
                    poll = queue.poll();
                    break;
                }
                queue.add(queue.poll());
            }
            if(poll.num == location) break;
        }
        return answer;
    }
}