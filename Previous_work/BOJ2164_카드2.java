import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int ans = 0;
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		while (true) {
			if (N == 1) {
				ans = queue.poll();
				break;
			}
			queue.poll();
			if (queue.size() == 1) {
				ans = queue.poll();
				break;
			}
			queue.add(queue.poll());
		}
		System.out.println(ans);
		sc.close();
	}
}
