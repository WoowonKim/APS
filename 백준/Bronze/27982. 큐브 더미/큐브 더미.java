import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][][] visited = new boolean[N + 1][N + 1][N + 1];
        int[][] arr = new int[M][3];
        for (int l = 0; l < M; l++) {
            int i = sc.nextInt(), j = sc.nextInt(), k = sc.nextInt();
            arr[l] = new int[]{i, j, k};
            visited[i][j][k] = true;
        }
        int ans = 0;
        for (int l = 0; l < M; l++) {
            int[] curr = arr[l];
            int i = curr[0], j = curr[1], k = curr[2];
            try {
                if (visited[i + 1][j][k] && visited[i - 1][j][k] && visited[i][j - 1][k] && visited[i][j + 1][k] && visited[i][j][k - 1] && visited[i][j][k + 1])
                    ans++;
            } catch (Exception ignored) {
            }
        }
        System.out.println(ans);
    }
}
