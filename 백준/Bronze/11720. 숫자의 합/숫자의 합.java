import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String line = sc.next();
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int num = line.charAt(i)-'0';
			ans += num;
		}
		System.out.println(ans);
	}
}