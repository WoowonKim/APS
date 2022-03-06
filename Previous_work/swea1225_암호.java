import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea1225_암호 {
	/**
	 * 8개의 숫자를 입력 받는다. 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫
	 * 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소한다. 이와 같은 작업을 한 사이클이라 한다. 숫자가 감소할
	 * 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 이 때의 8자리의 숫자 값이 암호가 된다. 
	 * input : tc, a1,a2.... a8 테스트케이스, 숫자 
	 * output : 테스트 케이스와 암호
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int T = 10;
		while (T-- > 0) {
			queue.clear();
			int sub = 1;
			int tc = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			while (queue.peek() - sub > 0) {
				queue.add(queue.poll() - sub);
				sub = (sub + 1) % 6;
				if (sub == 0)
					sub = 1;
			}
			queue.poll();
			queue.add(0);
			System.out.printf("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.printf("%d ", queue.poll());
			}
			System.out.println();
		}
		sc.close();
	}

}
