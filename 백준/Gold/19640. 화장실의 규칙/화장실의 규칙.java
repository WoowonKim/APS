import java.util.*;
import java.io.*;

public class Main {
    static class Person implements Comparable<Person> {
        int lineNum;
        int D;
        int H;
        boolean isTarget;

        public Person(int lineNum, int D, int H, boolean isTarget) {
            this.lineNum = lineNum;
            this.D = D;
            this.H = H;
            this.isTarget = isTarget;
        }

        @Override
        public int compareTo(Person o) {
            if (this.D > o.D) return -1;
            if (this.D == o.D) {
                if (this.H > o.H) return -1;
                if (this.H == o.H) {
                    if (this.lineNum < o.lineNum) return -1;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        Queue<Person>[] lines = new Queue[M];
        PriorityQueue<Person> order = new PriorityQueue<>();
        for (int i = 0; i < M; i++) lines[i] = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(stk.nextToken());
            int H = Integer.parseInt(stk.nextToken());
            int lineNum = i % M;
            boolean isTarget = i == K;
            if(i < M) order.add(new Person(lineNum, D, H, isTarget));
            else lines[lineNum].add(new Person(lineNum, D, H, isTarget));
        }
        int ans = 0;
        while(!order.isEmpty()) {
            Person curr = order.poll();
            if(curr.isTarget) break;
            if(!lines[curr.lineNum].isEmpty()) order.add(lines[curr.lineNum].poll());
            ans++;
        }
        System.out.println(ans);
    }
}