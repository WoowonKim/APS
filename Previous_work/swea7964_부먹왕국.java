import java.util.Scanner;

public class swea7964_부먹왕국 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] map = new int[N];
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextInt();
			}
			int ans = 0;
			int cnt = 0;
			for (int i = 0; i < map.length; i++) {
				if(map[i]==0){
					cnt++;
				}else{
					ans+=cnt/D;
					cnt = 0;
				}
				if(i==map.length-1) {
					ans+=cnt/D;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
