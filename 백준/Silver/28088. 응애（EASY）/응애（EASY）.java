import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] babies;
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        babies = new boolean[N];
        for (int i = 0; i < M; i++) babies[Integer.parseInt(br.readLine())] = true;

        for (int i = 0; i < K; i++) eungeh();

        System.out.println(M);
    }

    private static void eungeh() {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            int prev = (i + N - 1) % N;
            if(babies[next] && babies[prev]) continue;
            if(babies[next] || babies[prev]) arr.add(i);
        }
        babies = new boolean[N];
        arr.forEach(baby -> babies[baby] = true);
        M = arr.size();
    }
}
