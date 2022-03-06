import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		M += sc.nextInt();
		
		while(M>=60) {
			M -= 60;
			H++;
			if(H>=24) H-= 24;
		}
		System.out.println(H+" "+M);
		
	}

}
