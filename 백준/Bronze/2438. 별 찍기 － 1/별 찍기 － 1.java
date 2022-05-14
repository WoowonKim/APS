import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++) {
			sb.append("*");
			System.out.println(sb);
		}
	}
}
