import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int idx = Integer.MAX_VALUE;
		for(int i = 1; i <= 9; i++) {
			int num = sc.nextInt();
			if(num > max) {
				max = num;
				idx = i;
			}
			
		}
		System.out.print(max + " "+ idx);
	}
}