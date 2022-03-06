import java.util.Scanner;

public class swea7236_저수지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			int ans = 0;
			int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
			int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
			for (int i = 1; i < map.length - 1; i++) {
				for (int j = 1; j < map.length - 1; j++) {
					int dept = 8;
					for (int k = 0; k < dy.length; k++) {
						if (map[i + dx[k]][j + dy[k]] == 'G')
							dept--;
					}
					if (dept <= 1)
						dept = 1;
					if (ans < dept)
						ans = dept;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}

}
