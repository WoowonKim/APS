import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer[]> house = new ArrayList<Integer[]>();
	static List<Integer[]> chicken = new ArrayList<Integer[]>();
	static int N, M, totalChicken;
	static int[] sel;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] map = new int[N][N];
		M = sc.nextInt();
		sel = new int[M];
		ans = 1<<30;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int building = sc.nextInt();
				map[i][j] = building;
				if(building == 1) house.add(new Integer[] {i,j});
				if(building == 2) chicken.add(new Integer[] {i,j});
			}
		}
		totalChicken = chicken.size();
		comb(0,0);
		System.out.println(ans);
		sc.close();
	}
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			int totalChickenRange = 0;
			for(int i = 0; i < house.size(); i++) {
				int min = 1<<30;
				for(int j : sel) {
					int x = Math.abs(house.get(i)[0]-chicken.get(j)[0]);
					int y = Math.abs(house.get(i)[1]-chicken.get(j)[1]);
					int chickenRange = x+y;
					if(min > chickenRange) min = chickenRange;
				}
				totalChickenRange += min;
			}
			if (ans > totalChickenRange) ans = totalChickenRange;
			return;
		}
		for(int i = start; i < totalChicken; i++) {
			sel[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
}
