import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] map = new int[N][N];

		for (int i = 0; i < K; i++) {
			map[sc.nextInt()-1][sc.nextInt()-1] = -1;
		}

		int L = sc.nextInt();

		int[] time = new int[L];
		String[] command = new String[L];

		for (int i = 0; i < L; i++) {
			time[i] = sc.nextInt();
			command[i] = sc.next();
		}
		int commandIdx = 0;

		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		int dir = 0;

		int x = 0, y = 0;
		Queue<int[]> snake = new LinkedList<>();
		map[x][y] = 1;
		snake.add(new int[] {x, y});

		int sec = 0;
		while (true) {
			sec++;
			x += dx[dir];
			y += dy[dir];

			if (x < 0 || x >= N || y < 0 || y >= N || map[x][y] == 1)
				break;
			
			
			snake.add(new int[] {x,y});
			if (map[x][y] == 0) {
				int[] tail = snake.poll();
				map[tail[0]][tail[1]] = 0;
			}
			
			map[x][y] = 1;
			
			if (commandIdx < L && sec == time[commandIdx]) {
				if (command[commandIdx].equals("L"))
					dir = (dir + 1) % 4;
				else
					dir = (dir + 3) % 4;
				commandIdx++;
			}
		}
		System.out.println(sec);
	}

}
