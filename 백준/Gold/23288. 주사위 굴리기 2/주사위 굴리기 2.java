import java.util.Scanner;

public class Main {
	static class Dice {
		int top = 1, bottom = 6, left = 4, right = 3, up = 2, down = 5;

		public void setDice(int top, int bottom, int left, int right, int up, int down) {
			this.top = top;
			this.bottom = bottom;
			this.left = left;
			this.right = right;
			this.up = up;
			this.down = down;
		}
	}

	static Dice dice;
	static int n, m, score = 1, B, ans;
	static int[][] map;
	static int[] pos = { 1, 1 }, dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dice = new Dice();
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		visited = new boolean[n + 2][m + 2];
		map = new int[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int dir = 1;// 0 : 위 , 1 : 오른쪽, 2 : 아래 , 3 : 좌
		while (k != 0) {
			k--;
			int nr = pos[0] + dr[dir];
			int nc = pos[1] + dc[dir];
			if (map[nr][nc] == 0) {
				dir = (dir + 2) % 4;
				if (dir % 2 == 0)
					nr = nr + dr[dir] * 2;
				if (dir % 2 == 1)
					nc = nc + dc[dir] * 2;
			}
			pos[0] = nr;
			pos[1] = nc;
			switch (dir) {
			case 0:
				goNorth();
				break;
			case 2:
				goSouth();
				break;
			case 3:
				goWest();
				break;
			case 1:
				goEast();
				break;
			}
			if (dice.bottom > map[pos[0]][pos[1]]) {
				dir = (dir + 1) % 4;
			} else if (dice.bottom < map[pos[0]][pos[1]]) {
				dir = (dir + 3) % 4;
			}
			B = map[pos[0]][pos[1]];
			score = 1;
			visited = new boolean[n + 2][m + 2];
			ans += getScore(pos[0], pos[1]);
		}
		System.out.println(ans);
	}

	private static void goSouth() {
		dice.setDice(dice.up, dice.down, dice.left, dice.right, dice.bottom, dice.top);
	}

	private static void goNorth() {
		dice.setDice(dice.down, dice.up, dice.left, dice.right, dice.top, dice.bottom);
	}

	private static void goWest() {
		dice.setDice(dice.right, dice.left, dice.top, dice.bottom, dice.up, dice.down);
	}

	private static void goEast() {
		dice.setDice(dice.left, dice.right, dice.bottom, dice.top, dice.up, dice.down);
	}

	private static int getScore(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (map[nr][nc] == 0)
				continue;
			if (map[nr][nc] == B && !visited[nr][nc]) {
				score++;
				getScore(nr, nc);
			}
		}
		return score * B;
	}
}
