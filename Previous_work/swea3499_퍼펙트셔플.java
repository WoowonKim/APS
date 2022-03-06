import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea3499_퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<String> Queue1 = new LinkedList<String>();
		Queue<String> Queue2 = new LinkedList<String>();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				if ((N % 2 == 0) ? (i < N / 2) : (i < N / 2 + 1)) {
					Queue1.add(sc.next());
					continue;
				}
				Queue2.add(sc.next());
			}
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					sb.append(Queue1.poll());
					sb.append(" ");
					continue;
				}
				sb.append(Queue2.poll());
				sb.append(" ");
			}
			System.out.println("#" + tc + " " + sb);
		}
		sc.close();
	}
}
