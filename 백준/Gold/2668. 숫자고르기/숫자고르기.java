import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static PriorityQueue<Integer> pq;
	static int[] nums;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		nums = new int[N+1];
		visited = new boolean[N + 1];
		pq = new PriorityQueue<Integer>();
		for (int i = 1; i <= N; i++) {
			nums[i] =  sc.nextInt();
		}
		for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	private static void dfs(int curr, int st) {
		if(!visited[nums[curr]]) {
			visited[nums[curr]] = true;
            dfs(nums[curr], st);
            visited[nums[curr]] = false;
		}
		if(nums[curr] == st) pq.add(st);
	}
}