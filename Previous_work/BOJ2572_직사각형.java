import java.util.Scanner;

public class BOJ2572_직사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int m1 = sc.nextInt();
			int n1 = sc.nextInt();
			int m2 = sc.nextInt();
			int n2 = sc.nextInt();
			if (m1 > x2 || m2 < x1) {
				System.out.println("d");
				continue;
			}
			if (n1 > y2 || n2 < y1) {
				System.out.println("d");
				continue;
			}

			if (y1 == n2 || y2 == n1 || x1 == m2 || x2 == m1) {
				if (y1 == n2) {
					if (x1 == m2 || x2 == m1) {
						System.out.println("c");
						continue;
					}
				}
				if (y2 == n1) {
					if (x1 == m2 || x2 == m1) {
						System.out.println("c");
						continue;
					}
				}
				if (x1 == m2) {
					if (y1 == n2 || y2 == n1) {
						System.out.println("c");
						continue;
					}
				}
				if (x2 == m1) {
					if (y1 == n2 || y2 == n1) {
						System.out.println("c");
						continue;
					}
				}
				System.out.println("b");
				continue;
			}

			System.out.println("a");
		}
		sc.close();

	}
}
