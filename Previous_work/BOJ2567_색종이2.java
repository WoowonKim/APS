import java.util.Scanner;

public class BOJ2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 수
		int[][] map = new int[102][102];
		int len = 0;
		
		// 색종이 겹치기
		// 색종이 수 만큼 수행
		for (int num = 0; num < N; num++) {
			int dx = sc.nextInt()+1;	// y 축과 떨어진 거리
			int dy = sc.nextInt()+1;	// x 축과 떨어진 거리			
			for (int i = dy; i < 10 + dy; i++) {
				for (int j = dx; j < 10 + dx; j++) {
				map[i][j] = 1;
				}
			}			
		}
		
		// x 방향 또는 y 방향으로 훑어가면서 이전 자리와 다를때마다 1씩 더해준다. 1 0 -> +1 / 0 1 -> + 1
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
			// y 방향 훑기
			if (map[i][j] != map[i + 1][j]) len++; 
			// x 방향 훑기
			if (map[j][i] != map[j][i + 1]) len++; 
			}
		}	
		
		System.out.println(len);		
		sc.close();

	}
}
