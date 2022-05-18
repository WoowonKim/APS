import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println((int) Math.pow(2, N)-1);
		Hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}

	private static void Hanoi(int n, int from, int by, int to) {
		// TODO Auto-generated method stub
		if(n == 1) {
			sb.append(from+ " " + to + "\n");
		}else {
			Hanoi(n-1,from,to,by);
			sb.append(from+ " " + to + "\n");
			Hanoi(n-1, by, from, to);
		}
	}
}
