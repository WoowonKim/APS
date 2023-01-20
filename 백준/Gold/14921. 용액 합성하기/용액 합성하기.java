
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        int s = 0;
        int e = n - 1;

        while (true) {
            if (s == e) break;
            int sum = arr[s] + arr[e];
            if (Math.abs(sum) < Math.abs(ans)) ans = sum;
            if (sum > 0) e--;
            else if (sum < 0) s++;
            else break;
        }

        System.out.println(ans);

    }
}
