import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //[14697] 방 배정하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        boolean ans = false;
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());
        if(A==1 || B==1 || C==1) ans = true;

        out : for (int i = 0; i < N/A; i++) {
            for (int j = 0; j < N/B; j++) {
                for (int k = 0; k < N/C; k++) {
                    if (i * A + j * B + k * C == N) ans = true;
                    if(ans) break out;
                }
            }
        }
        System.out.println(ans ? 1 : 0);
    }
}
