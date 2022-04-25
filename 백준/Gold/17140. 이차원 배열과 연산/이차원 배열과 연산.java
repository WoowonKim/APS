import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class numCnt implements Comparable<numCnt> {
		int num;
		int cnt;

		public numCnt(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(numCnt o) {
			if(this.cnt == o.cnt) return this.num - o.num;
			return this.cnt - o.cnt;
		}

	}

	static int r, c, k, rowIdx, colIdx;
	static int[][] arr;
	static int[] counter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		arr = new int[101][101];
		counter = new int[101];
		rowIdx = 3;
		colIdx = 3;
		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				arr[i][j] =	sc.nextInt();
			}
		}

		int time = 0;
		while (arr[r][c] != k && time <= 100) {
			if (rowIdx >= colIdx)
				doR();
			else
				doC();
			time++;
		}
		System.out.println(time <= 100 ? time : -1);
	}

	private static void doR() {
		for (int i = 1; i <= rowIdx; i++) {
			for (int j = 1; j <= colIdx; j++) {
				counter[arr[i][j]]++;
			}
			change("row", i);
		}

	}

	private static void doC() {
		for (int j = 1; j <= colIdx; j++) {
			for (int i = 1; i <= rowIdx; i++) {
				counter[arr[i][j]]++;
			}
			change("col", j);
		}

	}

	private static void change(String op, int fixed) {
		PriorityQueue<numCnt> pq = new PriorityQueue<numCnt>();
		for (int i = 1; i <= 100; i++) {
			if (counter[i] == 0)
				continue;
			pq.add(new numCnt(i, counter[i]));
			counter[i]= 0;
		}
		int size = pq.size() * 2;
		if (op.equals("row")) {
			for (int i = 1; i <= 100; i += 2) {
				if(pq.isEmpty()) {
					arr[fixed][i] = 0;
					arr[fixed][i+1] = 0;
					continue;
				}
				numCnt curr = pq.poll();
				arr[fixed][i] = curr.num;
				arr[fixed][i + 1] = curr.cnt;
			}
			colIdx = size > 100? 100 : size > colIdx ? size: colIdx;
		} else {
			for (int i = 1; i <= 100; i += 2) {
				if(pq.isEmpty()) {
					arr[i][fixed] = 0;
					arr[i + 1][fixed] = 0;
					continue;
				}
				numCnt curr = pq.poll();
				arr[i][fixed] = curr.num;
				arr[i + 1][fixed] = curr.cnt;
			}
			rowIdx = size > 100? 100 : size > rowIdx ? size: rowIdx;
		}
	}

}
