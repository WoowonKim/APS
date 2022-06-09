import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		BigInteger bigA = new BigInteger(a);
		BigInteger bigB = new BigInteger(b);
		System.out.println(bigA.add(bigB));
	}
}