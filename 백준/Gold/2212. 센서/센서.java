import java.util.*;

public class Main {

    static int n, ans = Integer.MAX_VALUE, k;
    static int[] sensors, sel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        if(k >= n) {
            System.out.println(0);
            return;
        }
        Integer[] sensors = new Integer[n];
        Integer[] diff = new Integer[n - 1];
        for (int i = 0; i < n; i++) {
            sensors[i] = sc.nextInt();
        }
        Arrays.sort(sensors);

        for (int i = 0; i < n-1; i++) {
            diff[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(diff, Collections.reverseOrder());

        int ans = 0;
        for (int i = k-1; i < n-1; i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }
}
