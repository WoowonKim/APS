import java.util.Scanner;

public class BOJ1966_프린터 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] priority = new int[N];
			for (int i = 0; i < N; i++) {
				priority[i] = sc.nextInt();
			}
			int cnt = 0;
			int max = 0;
			int pointer = 0;
			for (int i = 0; i < N; i++) {
				if (priority[i] > max) {
					max = priority[i];
					pointer = i;
				}
			}
			priority[pointer] = 0;
			cnt++;
			while (pointer != M) {
				max = 0;
				for (int i = 0; i < N; i++) {
					if (priority[i] > max) {
						max = priority[i];
					}
				}
				while(priority[pointer] != max){
					pointer = (pointer+1)%N;
				}
				priority[pointer] = 0;
				cnt++;
			} // while
			System.out.println(cnt);
		}
		sc.close();
	}

}
