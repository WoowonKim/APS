import java.util.Scanner;

public class Main {
    public static void main(String[] args) {//[2503] 숫자 야구
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        boolean[] isPossible = new boolean[1000];
        for (int i = 111; i <= 999; i++) isPossible[i] = true;

        for (int i = 0; i < N; i++) {
            int tNum = sc.nextInt();
            int S = sc.nextInt();
            int B = sc.nextInt();
            for (int j = 111; j <= 999; j++) {
                if (!isPossible[j]) continue;
                isPossible[j] = check(tNum, S, B, j);
            }
        }
        for (int i = 111; i <= 999; i++) {
            if (isPossible[i]) ans++;
        }
        System.out.println(ans);
    }

    private static boolean check(int tNum, int s, int b, int cNum) {
        int strike = 0;
        int ball = 0;
        int[] ans = {tNum / 100, (tNum / 10) % 10, tNum % 10};
        int[] com = {cNum / 100, (cNum / 10) % 10, cNum % 10};
        if(com[0] == com[1] || com[0] == com[2] || com[1] == com[2]) return false;
        if(com[0] == 0 || com[1] == 0 || com[2] == 0) return false;
        for (int i = 0; i < 3; i++) {
            if (ans[i] == com[i]) strike++;
            else {
                if (com[i] == ans[0] || com[i] == ans[1] || com[i] == ans[2]) {
                    ball++;
                }
            }
        }
        return strike == s && ball == b;
    }
}
