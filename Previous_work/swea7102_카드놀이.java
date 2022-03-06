import java.util.Scanner;

public class swea7102_카드놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int card1 = sc.nextInt();
			int card2 = sc.nextInt();
			int[] sumCnt = new int[card1 + card2 + 1];
			for (int i = 1; i <= card1; i++) {
				for (int j = 1; j <= card2; j++) {
					sumCnt[i + j]++;
				}
			}
			int cntMax = 0;
			for (int i = 2; i < sumCnt.length; i++) { //L
				if (sumCnt[i] > cntMax) {
					cntMax = sumCnt[i];
				}
			}
			System.out.printf("#%d ",tc);
			for (int i = 2; i < sumCnt.length; i++) {
				if (sumCnt[i] == cntMax) {
					System.out.printf("%d ",i);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
