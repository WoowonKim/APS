import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			int floor = N%H==0?H:N%H;
			int col = N/H + 1;
			if(N%H==0) col--;
			System.out.print(floor+"");
			System.out.println(col<10?"0"+col:col);
		}
	}
}