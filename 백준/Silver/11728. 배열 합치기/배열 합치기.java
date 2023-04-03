import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        stk = new StringTokenizer(br.readLine());
        while (N-- > 0) pq.add(Integer.parseInt(stk.nextToken()));
        stk = new StringTokenizer(br.readLine());
        while (M-- > 0) pq.add(Integer.parseInt(stk.nextToken()));
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        System.out.println(sb);
    }

}
