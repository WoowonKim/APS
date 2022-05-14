import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int idx = 1;
		while(T-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("Case #"+ idx++ + ": "+ (a + b));
		}
	}
}
