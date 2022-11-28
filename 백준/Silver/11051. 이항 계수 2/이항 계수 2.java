import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] map = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (i > j) continue;
                if (i == j || i == 0) {
                    map[i][j] = 1;
                    continue;
                }
                map[i][j] = (map[i][j - 1] + map[i - 1][j - 1])%10007;
            }
        }
        System.out.println(map[k][n]);
    }
}