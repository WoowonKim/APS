import java.util.Scanner;

public class swea5215_햄버거 {
	static int maxScore;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			maxScore = 0;
			int ingNum = sc.nextInt();
			int maxCal = sc.nextInt();
			boolean[] sel = new boolean [ingNum];
			int[] score = new int[ingNum];
			int[] cal = new int[ingNum];
			int idx = 0;
			for (int i = 0; i < ingNum; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			powerset(score, cal, maxCal, sel, idx);
			System.out.println("#" + tc + " " + maxScore);
		}
		sc.close();
	}

	public static void powerset(int[] score, int[] cal, int maxCal, boolean[] sel, int idx) {
		if (idx == sel.length) {
			int scoreSum = 0;
			int calSum = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					scoreSum+=score[i];
					calSum+=cal[i];
					}
				}
			if (calSum <= maxCal && scoreSum >= maxScore) {
				maxScore = scoreSum;
			}
			return;
		}
		sel[idx] = true;
		powerset(score, cal, maxCal, sel, idx + 1);
		sel[idx] = false;
		powerset(score, cal, maxCal, sel, idx + 1);
	}
}
