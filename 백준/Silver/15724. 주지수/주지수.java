import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] map = new int[N+1][M+1];
		for(int i = 1; i < N+1; i++) {
			input = br.readLine().split(" ");
			for(int j = 1; j < M+1; j++) {
				int num = Integer.parseInt(input[j-1]);
				map[i][j] = num - map[i-1][j-1] + map[i-1][j] +map[i][j-1];
			}
		}
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0]);
			int y1 = Integer.parseInt(input[1]);
			int x2 = Integer.parseInt(input[2]);
			int y2 = Integer.parseInt(input[3]);
			System.out.println(map[x2][y2] - map[x1-1][y2] - map[x2][y1-1] + map[x1-1][y1-1]);
		}
	}
}
