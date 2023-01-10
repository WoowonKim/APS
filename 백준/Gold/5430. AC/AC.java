import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> deque;
		StringTokenizer stk;
		int T = sc.nextInt();
		sc.nextLine();
		out :while (T-- > 0) {
			String command = sc.nextLine();
			int N = sc.nextInt();
			sc.nextLine();
			stk = new StringTokenizer(sc.nextLine(), "[],");

			deque = new ArrayDeque<Integer>();

			for (int i = 0; i < N; i++) {
				deque.add(Integer.parseInt(stk.nextToken()));
			}
			boolean front = true;

			for (int i = 0; i < command.length(); i++) {
				char cmd = command.charAt(i);
				if (cmd == 'R') {
					front = !front;
					continue;
				}
				if (deque.isEmpty()) {
					sb.append("error\n");
					continue out;
				}
				if(front) deque.pollFirst();
				else deque.pollLast();
			}
			sb.append('[');
			if (front && !deque.isEmpty()) {
				sb.append(deque.pollFirst());
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else if(!front && !deque.isEmpty()){
				sb.append(deque.pollLast());
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
			sb.append(']').append('\n');
		}
		System.out.println(sb);
	}
}