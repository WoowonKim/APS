import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int left = j - 1 >= 0 ? map[i][j - 1] : 0;
                int up = i - 1 >= 0 ? map[i - 1][j] : 0;
                int cross = (j - 1 > 0) && (i - 1 > 0) ? map[i - 1][j - 1] : 0;
                int max = Math.max(left, Math.max(up, cross));
                map[i][j] += max;
            }
        }
        System.out.println(map[N-1][M-1]);
    }
}
