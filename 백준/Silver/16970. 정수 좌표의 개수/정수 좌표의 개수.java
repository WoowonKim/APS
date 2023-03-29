import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[][] map = new int[51][51];

        for (int i = 0; i <= 50; i++) for (int j = 0; j <= 50; j++) map[i][j] = gcd(i, j) + 1;
        int ans = 0;
        for (int i = 0; i <= N; i++) for (int j = 0; j <= M; j++) {
            for (int k = 0; k <= N; k++ ) for (int l = 0; l <= M; l++) {
                int x = Math.abs(i - k);
                int y = Math.abs(j - l);
                if (map[x][y] == K) ans++;
            }
        }
        System.out.println(ans/2);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
