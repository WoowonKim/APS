import java.util.Scanner;

public class swea1873_배틀필드 {
	static int x, y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			x = 0;
			y = 0;
			for (int i = 0; i < H; i++) {
				String L = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = L.charAt(j);
					if (L.charAt(j) == '<' || L.charAt(j) == '^' || L.charAt(j) == 'v' || L.charAt(j) == '>') {
						x = i;
						y = j;
					}
				}
			} // map 입력
			int N = sc.nextInt();
			String command = sc.next();
			for (int i = 0; i < N; i++) {
				char c = command.charAt(i);
				switch (c) {
				case 'U':
					map = goUp(map);
					break;
				case 'D':
					map = goDown(map);
					break;
				case 'L':
					map = goLeft(map);
					break;
				case 'R':
					map = goRight(map);
					break;
				case 'S':
					map = shoot(map);
					break;
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} // testCase
		sc.close();
	}// main

	private static char[][] shoot(char[][] map) {
		int xB = x;
		int yB = y;
		char c = map[x][y];
		switch (c) {
		case '<':
			while (--yB >= 0)
				if (map[xB][yB] == '*') {
					map[xB][yB] = '.';
					break;
				} else if (map[xB][yB] == '#') {
					break;
				}
			break;

		case '^':
			while (--xB >= 0)
				if (map[xB][yB] == '*') {
					map[xB][yB] = '.';
					break;
				} else if (map[xB][yB] == '#') {
					break;
				}
			break;
		case '>':
			while (++yB < map[0].length)
				if (map[xB][yB] == '*') {
					map[xB][yB] = '.';
					break;
				} else if (map[xB][yB] == '#') {
					break;
				}
			break;
		case 'v':
			while (++xB < map.length)
				if (map[xB][yB] == '*') {
					map[xB][yB] = '.';
					break;
				} else if (map[xB][yB] == '#') {
					break;
				}
			break;
		}
		return map;
	}

	private static char[][] goRight(char[][] map) {
		map[x][y] = '>';
		if (y + 1 < map[0].length && map[x][y + 1] == '.') {
			map[x][y] = '.';
			map[x][y + 1] = '>';
			y++;
		}
		return map;
	}

	private static char[][] goLeft(char[][] map) {
		map[x][y] = '<';
		if (y - 1 >= 0 && map[x][y - 1] == '.') {
			map[x][y] = '.';
			map[x][y - 1] = '<';
			y--;
		}
		return map;

	}

	private static char[][] goDown(char[][] map) {
		map[x][y] = 'v';
		if (x + 1 < map.length && map[x + 1][y] == '.') {
			map[x][y] = '.';
			map[x + 1][y] = 'v';
			x++;
		}
		return map;
	}

	private static char[][] goUp(char[][] map) {
		map[x][y] = '^';
		if (x - 1 >= 0 && map[x - 1][y] == '.') {
			map[x][y] = '.';
			map[x - 1][y] = '^';
			x--;
		}
		return map;
	}

}
