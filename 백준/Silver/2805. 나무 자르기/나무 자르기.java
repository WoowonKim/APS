import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, tallest;
    static int ans = 0;
    static int[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        trees = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(stk.nextToken());
            tallest = Math.max(tallest, trees[i]);
        }
        getAns();
        System.out.println(ans);
    }
    static void getAns() {
        int L = 0; int R = tallest;
        while (L < R) {
            int mid = (L + R)/2;
            long sum = 0;
            for (int tree : trees) {
                int remain = tree - mid;
                if(remain > 0) sum += remain;
            }
            if(sum < M) R = mid;
            else L = mid + 1;
        }
        ans = L - 1;
    }

}
