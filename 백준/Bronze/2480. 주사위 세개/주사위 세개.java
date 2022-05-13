import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int max;
		int same;
		if(a > b && a > c) max = a;
		else if(b > c) max = b;
		else max = c;
		
		if(a==b && a==c) System.out.println(10000+a*1000);
		else if(a != b && a != c && b != c) System.out.println(max*100);
		else {
			if(a==b || a==c) same = a;
			else same = b;
			System.out.println(1000+same*100);
		}
	}
}
