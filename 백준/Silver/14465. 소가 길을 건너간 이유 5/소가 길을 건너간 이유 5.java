import java.util.Arrays;
import java.util.Scanner;

/*
[14465] 소가 길을 건나간 이유 5
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int B = sc.nextInt();
        boolean[] broken = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            broken[sc.nextInt()] = true;
        }
        int temp = 0;
        for (int i = 1; i <= K; i++) {
            if (broken[i]) temp++;
        }
        int ans = temp;
        for (int i = 2, k = K + 1; k <= N; i++, k++) {
            if (broken[i - 1]) temp--;
            if (broken[k]) temp++;
            ans = Math.min(ans, temp);
        }
        System.out.println(ans);
    }

}
