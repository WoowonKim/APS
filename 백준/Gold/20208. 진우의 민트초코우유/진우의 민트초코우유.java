import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, M, H, ans;
    static List<int[]> mliks = new ArrayList<>();
    static int[][] map;
    static boolean[] visited;
    static int[] home;

    public static void main(String[] args) {
        input();
        backTrack(M, home, 0);
        System.out.println(ans);
    }

    private static void backTrack(int remain, int[] curr, int cnt) {
        for (int i = 0; i < mliks.size(); i++) {
            int[] next = mliks.get(i);
            if(visited[i]) continue;
            int dist = getDist(curr, next);
            if(remain >= dist) {
                visited[i] = true;
                backTrack(remain - dist + H, next, cnt+1);
                visited[i] = false;
            }
        }
        if(remain >= getDist(curr, home)) ans = Math.max(ans, cnt);
    }

    private static int getDist(int[] from, int[] to) {
        return Math.abs(to[0] - from[0]) + Math.abs(to[1] - from[1]);
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) home = new int[]{i, j};
                if (map[i][j] == 2) {
                    mliks.add(new int[]{i, j});
                }
            }
        visited = new boolean[mliks.size()];
    }

}
