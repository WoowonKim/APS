import java.util.Scanner;

public class swea1493_새로운연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map = new int[500][500];
		int num = 1;
		for (int i = 1; i < 500; i++) {
			for (int j = 1, k=0; j <= i; k++,j++) {
				map[i - k][j] = num++;
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int xp = 0, yp = 0;
			int xq = 0, yq = 0;
			int ans = 0;
			for (int i = 1; i < 500; i++) {
				for (int j = 1; j < 500; j++) {
					if (map[i][j] == p) {
						xp=i;
						yp=j;
					}
					if(map[i][j]==q) {
						xq=i;
						yq=j;
					}
				}
				if(xq != 0 && yq!=0 && xp !=0 &&yp!=0 ) {
					ans = map[xq+xp][yq+yp];
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}
}
