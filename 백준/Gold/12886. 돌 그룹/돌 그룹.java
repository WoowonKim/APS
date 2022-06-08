import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[3];
		int sum = 0;
		boolean[][] visited = new boolean[1500][1500];
		for (int i = 0; i < 3; i++) {
			nums[i] = sc.nextInt();
			sum += nums[i];
		}
		if(sum%3 != 0) {
			System.out.println(0);
			return;
		}
		visited[nums[0]][nums[1]] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { nums[0], nums[1] });
		while (!q.isEmpty()) {
			int[] temp = new int[] {q.peek()[0], q.peek()[1], sum-q.peek()[0]-q.peek()[1]};
			q.poll();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(temp[i] < temp[j]) {
						int num2 = temp[i] * 2;
						int num1 = temp[j] - temp[i];
						if(visited[num1][num2]) continue;
						visited[num1][num2] = true;
						q.add(new int[] {num1, num2});
					}
				}
			}
		}
		System.out.println(visited[sum/3][sum/3]? 1:0);
	}
}