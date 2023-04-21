import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int N, M, ans;
    static int[][] map;
    static int[][] copy;
    static List<int[]> cctvs;
    static int[] dirs, cctv;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = Integer.MAX_VALUE;
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        cctvs = new ArrayList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > 0 && map[i][j] < 6) cctvs.add(new int[]{i, j});
            }
        dirs = new int[cctvs.size()];
        setDir(0);
        System.out.println(ans);
    }

    private static void setDir(int depth) {
        if (depth == cctvs.size()) {
            cntBlindSpot();
            return;
        }
        for (int i = 0; i < 4; i++) {
            dirs[depth] = i;
            setDir(depth + 1);
        }
    }

    private static void cntBlindSpot() {
        copy = new int[N][M];
        for (int i = 0; i < N; i++) copy[i] = map[i].clone();
        for (int i = 0; i < cctvs.size(); i++) {
            cctv = cctvs.get(i);
            int type = map[cctv[0]][cctv[1]];
            int dir = dirs[i];
            turnOnCCTV(type, dir);
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) if (copy[i][j] == 0) cnt++;
        ans = Math.min(ans, cnt);
    }

    private static void turnOnCCTV(int type, int dir) {
        switch (type) {
            case 1:
                watch(dir);
                break;
            case 2:
                watch(dir);
                watch((dir + 2) % 4);
                break;
            case 3:
                watch(dir);
                watch((dir + 1) % 4);
                break;
            case 4:
                watch(dir);
                watch((dir + 1) % 4);
                watch((dir + 2) % 4);
                break;
            case 5:
                watch(0);
                watch(1);
                watch(2);
                watch(3);
                break;
        }
    }

    private static void watch(int dir) {
        int nr = cctv[0] + dr[dir];
        int nc = cctv[1] + dc[dir];
        while (true) {
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) break;
            if (copy[nr][nc] == 6) break;
            if (copy[nr][nc] == 0) copy[nr][nc] = -1;
            nr += dr[dir];
            nc += dc[dir];
        }
    }

}
