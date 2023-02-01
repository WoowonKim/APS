import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int whiteCnt, blueCnt;
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        map = new int[N][N];
        blueCnt = 0; whiteCnt = 0;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 0) whiteCnt++;
                else blueCnt++;
            }
        }
        for (int size = 2; size <= N; size *= 2) {
            for (int r = 0; r < N; r += size) {
                for (int c = 0; c < N; c += size) {
                    check(r, c, size);
                }
            }
        }
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(map[i][j] != map [r][c]) {
                    return;
                }
            }
        }
        if(map[r][c] == 0) whiteCnt -= 3;
        else blueCnt -= 3;
    }
}