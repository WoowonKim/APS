import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}
		int ans = 0;
		while(pq.size()!=1) {
			int temp = pq.poll()+pq.poll();
			ans += temp;
			pq.add(temp);
		}
		System.out.println(ans);
	}
}