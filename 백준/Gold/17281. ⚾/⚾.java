import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int[] turn = new int[8];
	static boolean[] visited = new boolean[9];
	static int ans, N;
	static int inning[][];
	
	public static void main(String[] args) throws Exception {
		ans = 0;
		N = sc.nextInt();
		inning = new int[N][9];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 9; j++) {
				inning[i][j] = sc.nextInt();
			}
		}
		turn = new int[8];
		setTurn(0, 0);
		System.out.println(ans);
	}

	private static void setTurn(int idx, int sel) {
		if (sel == 8) {
			playGame();
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				turn[idx] = i;
				setTurn(idx + 1, sel + 1);
				visited[i] = false;
			}
		}
	}

	private static void playGame() {
//		Queue<Integer> q = new LinkedList<Integer>();
//		for (int i = 0; i < 8; i++) {
//			if (i == 3)
//				q.add(0);
//			q.add(turn[i]);
//		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 8; i++) {
			list.add(turn[i]);
		}
		list.add(3, 0);
		int score = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			int outCnt = 0;
			int ru = 0;
			while (outCnt < 3) {
//				int curr = q.poll();
				idx %= 9;
				int curr = list.get(idx);
				int result = inning[i][curr];
				if(result == 0) {
					outCnt++;
				} else {
					ru = (ru<<1) + 1;
					for(int k = 1; k < result; k++) {
						if(ru >= 8) {
							ru -= 8;
							score++;
						}
						ru = ru<<1;
					}
					if(ru >= 8) {
						ru -= 8;
						score++;
					}
				}
//				q.add(curr);
				idx++;
			}
		}
		ans = Math.max(score, ans);
	}
}
