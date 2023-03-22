
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            br.readLine();
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            /*
            . == 46
            o == 111
            > == 62
            < == 60
            v == 118
            ^ == 94
             */
            int[][] map = new int[N + 2][M + 2];
            for (int i = 1; i <= N; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 1; j <= M; j++) {
                    map[i][j] = chars[j - 1];
                }
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if(map[i][j] == 111 && isCandy(map,i,j)) ans++;
                }
            }

            System.out.println(ans);
        }
    }

    static boolean isCandy(int[][] map, int r, int c) {
        if(map[r-1][c] == 118 && map[r+1][c] == 94) return true;
        if(map[r][c - 1] == 62 && map[r][c +1] == 60) return true;
        return false;
    }
}
