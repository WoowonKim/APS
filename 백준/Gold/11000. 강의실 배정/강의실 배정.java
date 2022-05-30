import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int N = Integer.parseInt(br.readLine());
		int[][] clas = new int[N][2];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
		for(int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			clas[i][0] = s;
			clas[i][1] = t;
		}
		
		Arrays.sort(clas, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1 == o2) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		pq.add(clas[0][1]);
		
		for(int i = 1; i < N; i++) {
			if(pq.peek() <= clas[i][0]) pq.poll();
			
			pq.add(clas[i][1]);
		}
		System.out.println(pq.size());
	}

}