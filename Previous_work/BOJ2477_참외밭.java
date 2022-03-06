import java.util.Scanner;

public class BOJ2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[][] farm = new int[6][2];
	
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				farm[i][j] = sc.nextInt();
			}
		}
		int[] used = new int[2];
		int sub = 1;
		int total = 1;
		int idx = 0;
		for (int i = 0; i < 6; i++) {
			int next = i + 2;
			if (next > 5)
				next -= 6;
			if (farm[i][0] == farm[next][0]) {
				int nextIdx = i+1;
				if (nextIdx > 5)
					nextIdx -= 6;
				used[idx++] = farm[nextIdx][0];
				sub *= farm[nextIdx][1];
				continue;
			}
		}
		for(int i = 0; i<6; i++) {
	
			if(farm[i][0]==used[0]||farm[i][0]==used[1]) {
				continue;
			}
			total *= farm[i][1];
		}
		System.out.println((total-sub)*k);
		sc.close();
	}
}
