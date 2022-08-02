import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int now = 0;

        Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        int i = 0;
        while(count < jobs.length){
            while (i< jobs.length && jobs[i][0] <= now){
                queue.add(jobs[i++]);
            }

            if(queue.isEmpty()){
                now = jobs[i][0];
            }else{
                int[] tmp = queue.poll();
                answer += tmp[1] + now - tmp[0];
                now += tmp[1];
                count++;
            }
        }

        return answer/ jobs.length;
    }
}