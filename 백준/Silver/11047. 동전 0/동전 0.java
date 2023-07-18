import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = N - 1; i >= 0; i--) {
            ans += K/arr[i];
            K %= arr[i];
        }
        System.out.println(ans);
    }
}
