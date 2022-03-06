import java.util.Scanner;

public class swea2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int houseNum = 1;
		int addH = 6;
		int ans = 1;
		while(true) {
			if (N<=houseNum) {
				System.out.println(ans);
				break;
			}
			ans++;
			houseNum += addH;
			addH += 6;
		}
	}
}
