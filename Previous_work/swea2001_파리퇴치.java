import java.util.Scanner;
 
public class swea2001_파리퇴치 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int ans = 0;
            int max = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] fly = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    fly[i][j] = sc.nextInt();
                }
            }
            int mov = N - M + 1;
            for (int k = 0; k < mov; k++) {
                for (int s = 0; s < mov; s++) {
                    for (int i = 0 + k; i < M + k; i++) {
                        for (int j = 0+s; j < M+s; j++) {
                            ans += fly[i][j];
                        }
                    }
                    if (ans >max) {
                        max = ans;
                    }
                    ans = 0;
                }
            }
            System.out.println("#" + tc + " " + max);
        } // tc
        sc.close();
    }// main

}