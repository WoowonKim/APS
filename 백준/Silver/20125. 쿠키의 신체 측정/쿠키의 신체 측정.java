import java.util.*;

class Main {
    static char[][] map;
    static StringBuilder sb;
    static int N;
    static int[] heart;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) map[i] = sc.next().toCharArray();
        out: for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (map[i][j] == '*') {
                    getAns(i, j);
                    break out;
                }
        System.out.println(sb);
    }

    private static void getAns(int x, int y) {
        heart = new int[2];
        heart[0] = x + 1;
        heart[1] = y;
        sb.append(x + 2).append(" ").append(y + 1).append("\n");
        sb.append(leftArm());
        sb.append(rightArm());
        sb.append(body());
        sb.append(leftLeg());
        sb.append(rightLeg());
    }

    private static String leftArm() {
        int cnt = 0;
        int y = heart[1] - 1;
        while (y >= 0) {
            if (map[heart[0]][y] == '*') cnt++;
            y--;
        }
        return cnt + " ";
    }

    private static String rightArm() {
        int cnt = 0;
        int y = heart[1] + 1;
        while (y < N) {
            if (map[heart[0]][y] == '*') cnt++;
            y++;
        }
        return cnt + " ";
    }

    private static String leftLeg() {
        int cnt = 0;
        int x = heart[0] + 1;
        while (x < N) {
            if (map[x][heart[1] - 1] == '*') cnt++;
            x++;
        }
        return cnt + " ";
    }
    private static String rightLeg() {
        int cnt = 0;
        int x = heart[0] + 1;
        while (x < N) {
            if (map[x][heart[1] + 1] == '*') cnt++;
            x++;
        }
        return cnt + " ";
    }

    private static String body() {
        int cnt = 0;
        int x = heart[0] + 1;
        while (x < N) {
            if (map[x][heart[1]] == '*') cnt++;
            x++;
        }
        return cnt + " ";
    }
}
