
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

		StringTokenizer stk;
		int winning = 0;
		int[] score = new int[3];
		Date lastScoredTime = sdf.parse("00:00");
		Date totalTime = sdf.parse("48:00");
		long[] aHeadTime = new long[3];

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			stk = new StringTokenizer(br.readLine());
			int scoredTeam = Integer.parseInt(stk.nextToken());
			Date scoredTime = sdf.parse(stk.nextToken());

			score[scoredTeam]++; //득점
			
			if (winning == 1) {//1이 이기고 있으면
				aHeadTime[1] += scoredTime.getTime() - lastScoredTime.getTime(); 
			} else if (winning == 2) {//2가 이기고 있으면
				aHeadTime[2] += scoredTime.getTime() - lastScoredTime.getTime();
			}
			
			lastScoredTime = scoredTime;
			
			winning = score[1] == score[2] ? 0 : score[1] > score[2] ? 1 : 2;
		}
		
		if (winning == 1) {//1이 이기고 있으면
			aHeadTime[1] += totalTime.getTime() - lastScoredTime.getTime(); 
		} else if (winning == 2) {//2가 이기고 있으면
			aHeadTime[2] += totalTime.getTime() - lastScoredTime.getTime();
		}
		
		System.out.println(sdf.format(new Date(aHeadTime[1])));
		System.out.println(sdf.format(new Date(aHeadTime[2])));
	}
}
