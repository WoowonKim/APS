import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] babies;
    static int[] buffer;
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        babies = new int[N];
        buffer = new int[N];
        for (int i = 0; i < M; i++) babies[Integer.parseInt(br.readLine())] = 1;

        for (int i = 0; i < K; i++) eungeh();

        System.out.println(Arrays.stream(babies).sum());
    }

    private static void eungeh() {
        Arrays.fill(buffer, 0);
        for(int i = 0; i < N; i++) {
            int next = (i + 1) % N;
            int prev = (i + N - 1) % N;
            if(babies[i] == 1) {
                buffer[next] ^= 1;
                buffer[prev] ^= 1;
            }
        }
        int[] temp = babies;
        babies = buffer;
        buffer = temp;
    }
}
