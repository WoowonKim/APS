import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> Q = new PriorityQueue<>(
				(Integer o1, Integer o2) -> Math.abs(o1) ==  Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2));
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				if (Q.isEmpty())
					System.out.println(0);
				else
					System.out.println(Q.poll());
			} else
				Q.add(num);
		}
		sc.close();
	}

}