import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int[] indegree;
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        indegree = new int[N + 1];
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(stk.nextToken());
            int prev = Integer.parseInt(stk.nextToken());
            for (int j = 1; j < k; j++) {
                int curr = Integer.parseInt(stk.nextToken());
                graph.get(prev).add(curr);
                indegree[curr]++;
                prev = curr;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 1; i <= N; i++) if(indegree[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append("\n");
            cnt++;
            for(int link : graph.get(curr)) if(--indegree[link] == 0) queue.add(link);
        }

        System.out.println(cnt == N ? sb : 0);
    }
}