import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, ans;
    static int[] arr, sel;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N];
        sel = new int[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        perm(0);
        System.out.println(ans);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            cal();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sel[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static void cal() {
        int temp = 0;
        for (int i = 1; i < N; i++) {
            temp += Math.abs(arr[sel[i - 1]] - arr[sel[i]]);
        }
        ans = Math.max(ans, temp);
    }

}
