import java.util.Scanner;

public class Main {
    static final int div = 1000000003;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[1001][1001];
        for(int i = 1; i < 1001; i++) {
            for(int j = 1; j < 1001; j++) {
                if(i == 1) {
                    dp[i][j] = j;
                    continue;
                } else if (i > j/2) {
                    continue;
                } else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j-2])%div;
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}