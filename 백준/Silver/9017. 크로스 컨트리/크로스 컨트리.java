import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0 ) {
            int N = sc.nextInt();

            int[] result = new int[N];
            int[] teamCnt = new int[201];
            for(int i = 0; i < N; i++) {
                int team = sc.nextInt();
                result[i] = team;
                teamCnt[team]++;
            }

            int ans = 0;
            int score = 0;
            int[] cnt = new int[201];
            int[] fifth = new int[201];
            int[] scores = new int[201];

            for(int i = 0; i < N; i++ ) {
                int curr = result[i];
                cnt[curr]++;
                if(teamCnt[curr] < 6) continue;
                score++;
                if(cnt[curr] <= 4) {
                    scores[curr] += score;
                }
                if(cnt[curr] == 5) {
                    fifth[curr] = i + 1;
                    ans = curr;
                }
            }

            for(int i = 0; i < 201; i++) {
                if(scores[i] == 0) continue;
                if(scores[i] < scores[ans]) ans = i;
                else if(scores[i] == scores[ans]) ans = fifth[i] < fifth[ans] ? i : ans;
            }
            System.out.println(ans);
        }
    }
}
