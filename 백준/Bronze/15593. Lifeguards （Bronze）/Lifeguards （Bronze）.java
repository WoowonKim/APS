import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[1000];
        int[][] cows = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int st = Integer.parseInt(str[0]);
            int ed = Integer.parseInt(str[1]);
            cows[i][0] = st;
            cows[i][1] = ed;
            for(int j = st; j < ed; j++) time[j]++;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int temp = 0;
            int[] curr = cows[i];
            for(int j = curr[0]; j < curr[1]; j++) time[j]--;
            for(int k = 0; k < 1000; k++) if(time[k] > 0) temp++;
            ans = Math.max(temp, ans);
            for(int j = curr[0]; j < curr[1]; j++) time[j]++;
        }
        System.out.println(ans);
    }
}
