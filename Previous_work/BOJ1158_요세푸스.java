import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158_요세푸스 {
	/**
	 * 1번부터 N번까지 사람이 원을 이루며 앉아 있다. 양의 정수 K(K<=N)번째 사람을 순서대로 제거한다. 원으 사람이 제거되는 순서를
	 * 요세푸스 순열이라 한다. 요세푸스 순열을 구하여라 input : N, K output : 요세푸스 순열
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i = 1; i <=N; i++) {
			queue.add(i);
		}
		sb.append("<");
		int idx = K - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < idx; j++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll());
			if(i==N-1) sb.append(">");
			else sb.append(", ");
		}
		System.out.println(sb);
		sc.close();
	}

}
